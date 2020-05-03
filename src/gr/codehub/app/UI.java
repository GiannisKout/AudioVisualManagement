package gr.codehub.app;

import java.awt.*;
import java.util.Scanner;

public class UI {

    public UserChoice menuInterface(){
        System.out.println("1. Add a media file  2. Remove a media file" +
                "  3. Display media list  4. Delete All" +
                "  5. Save media list  6. Load media list  0. Exit" +
                "");

        int choice;
        Scanner scanner = new Scanner(System.in);
        try{
            choice = scanner.nextInt();
            switch (choice){
                case 1: return UserChoice.ADD_MEDIA;
                case 2: return UserChoice.REMOVE_MEDIA;
                case 3: return UserChoice.DISPLAY_MEDIA_LIST;
                case 4: return UserChoice.DELETE_ALL;
                case 5: return UserChoice.SAVE;
                case 6: return UserChoice.LOAD;
                case 0: return UserChoice.EXIT;
                default: return UserChoice.ERROR;
            }
        }
        catch (Exception e){
            return UserChoice.ERROR;
        }
    }

    public MediaFile createMediaFile(){
        MediaFile newMediaFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the type of your file? (Video/Audio/Image)");
        String mediaType = scanner.next();
        if (mediaType.equalsIgnoreCase("video")){
            System.out.println("Give me fileName:");
            String fileName = scanner.next();
            System.out.println("Give me size:");
            float size = scanner.nextFloat();
            System.out.println("Give me fileType:");
            String fileType = scanner.next();
            System.out.println("Give me duration:");
            float duration = scanner.nextFloat();
            newMediaFile = new Video(fileName, size, fileType, duration);
        }
        else if (mediaType.equalsIgnoreCase("audio")){
            System.out.println("Give me fileName:");
            String fileName = scanner.next();
            System.out.println("Give me size:");
            float size = scanner.nextFloat();
            System.out.println("Give me fileType:");
            String fileType = scanner.next();
            System.out.println("Give me duration:");
            float duration = scanner.nextFloat();
            newMediaFile = new Audio(fileName, size, fileType, duration);
        }
        else if (mediaType.equalsIgnoreCase("image")){
            System.out.println("Give me fileName:");
            String fileName = scanner.next();
            System.out.println("Give me size:");
            float size = scanner.nextFloat();
            System.out.println("Give me fileType:");
            String fileType = scanner.next();
            newMediaFile = new Image(fileName, size, fileType);
        }
        else{
            System.out.println("Wrong type! Exiting...");
            return null;
        }

        System.out.println("File successfully added!!");
        return newMediaFile;
    }

    public void manageMediaList(MediaList mediaList){
//        "1. Add a media file  2. Remove a media file" +
//                "  3. Display media list  4. Delete All" +
//                "  5. Save media list  6. Load media list  0. Exit"
        UserChoice userChoice;

        do {
            userChoice = menuInterface();
            switch (userChoice){
                case ADD_MEDIA:
                    MediaFile mediaFile = createMediaFile();
                    if (mediaFile != null)
                        mediaList.addMediaFile(mediaFile);
                    break;
                case REMOVE_MEDIA:
                    System.out.println("Give an index to remove:");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    mediaList.removeMediaFile(index);
                    break;
                case DISPLAY_MEDIA_LIST:
                    mediaList.displayMediaList();
                    break;
                case DELETE_ALL:
                    mediaList.deleteAll();
                    break;
                case SAVE:
                    mediaList.saveMediaList("MyMediaList.txt");
                    break;
                case LOAD:
                    mediaList.loadMediaList("MyMediaList.txt");
                    break;
                case ERROR:
                    System.out.println("Wrong input! Please give integer number.");
                    break;
            }
        }while (userChoice != UserChoice.EXIT);
    }

}
