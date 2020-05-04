package gr.codehub.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MediaList {
    private ArrayList<MediaFile> mediaList = new ArrayList<>();

    public void displayMediaList(){
        if (mediaList.isEmpty()) {
            System.out.println("No media inserted!");
        }
        else{
            mediaList.forEach(System.out::println);
        }
    }

    public void addMediaFile(MediaFile newMediaFile){
        mediaList.add(newMediaFile);
    }

    public void removeMediaFile(int index){
        if (mediaList.isEmpty())
            System.out.println("Media list is empty!");
        else if (index >= 0 && index < mediaList.size()){
            mediaList.remove(index);
        }
        else
            System.out.println("Index out of range!");
    }

    public void deleteAll(){
        if(!mediaList.isEmpty())
            mediaList.clear();
    }

    public boolean isEmpty(){
        return mediaList.isEmpty();
    }

    public void saveMediaList(String listName){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            PrintWriter printWriter = new PrintWriter(new File(listName));
            for (var mediaFile : mediaList){
                if (mediaFile.getClass() == Video.class) {
                    Video f = (Video)mediaFile;
                    String text = "v" + "," + f.getId() + "," + f.getFileName() + "," + f.getSize() + ","
                            + f.getFileType() + "," + f.getCreator() + "," + f.getDescription() + ","
                            + formatter.format(f.getDateAdded())  + "," + (f.getDateCreated()!=null?formatter.format(f.getDateCreated()):"00/00/0000")
                            + "," + f.getDuration() + "," + f.getProducer();
                    printWriter.println(text);
                }
                else if (mediaFile.getClass() == Audio.class) {
                    Audio f = (Audio)mediaFile;
                    String text = "a" + "," + f.getId() + "," + f.getFileName() + "," + f.getSize() + ","
                            + f.getFileType() + "," + f.getCreator() + "," + f.getDescription() + ","
                            + formatter.format(f.getDateAdded())  + "," + (f.getDateCreated()!=null?formatter.format(f.getDateCreated()):"00/00/0000")
                            + "," + f.getDuration() + "," + f.getSinger();
                    printWriter.println(text);
                }
                else if (mediaFile.getClass() == Image.class) {
                    Image f = (Image) mediaFile;
                    String text = "i" + "," + f.getId() + "," + f.getFileName() + "," + f.getSize() + ","
                            + f.getFileType() + "," + f.getCreator() + "," + f.getDescription() + ","
                            + formatter.format(f.getDateAdded())  + "," + (f.getDateCreated()!=null?formatter.format(f.getDateCreated()):"00/00/0000");
                    printWriter.println(text);
                }
            }
            printWriter.close();
            System.out.println("Media list successfully saved!");
        }
        catch (FileNotFoundException e){
            System.out.println("The file cannot be saved!");
        }
    }

    public void loadMediaList(String listName){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Scanner scanner = new Scanner(new File(listName));
            mediaList.clear();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                if (words[0].equalsIgnoreCase("v")){
                    Video newVideoFile = new Video(words[2],Float.parseFloat(words[3]),
                            words[4], words[5], words[6], formatter.parse(words[8]),Float.parseFloat(words[9]),words[10]);
                    mediaList.add(newVideoFile);
                }
                else if (words[0].equalsIgnoreCase("a")){
                    Audio newAudioFile = new Audio(words[2],Float.parseFloat(words[3]),
                            words[4], words[5], words[6], formatter.parse(words[8]),Float.parseFloat(words[9]),words[10]);
                    mediaList.add(newAudioFile);
                }
                else if (words[0].equalsIgnoreCase("i")) {
                    Image newImageFile = new Image(words[2],Float.parseFloat(words[3]),
                            words[4], words[5], words[6], formatter.parse(words[8]));
                    mediaList.add(newImageFile);
                }

            }
            System.out.println("Media list successfully loaded!");
        }
        catch (FileNotFoundException | ParseException e){
            System.out.println("The file cannot be loaded!");
        }
    }

    public MediaList getFileByName(String fileName){
        MediaList foundMediaFiles = new MediaList();
        mediaList.forEach(mediaFile -> {
            if (mediaFile.getFileName().equalsIgnoreCase(fileName)) {
                    foundMediaFiles.addMediaFile(mediaFile);
            }
        });
        if (foundMediaFiles.isEmpty())
            return null;

        return foundMediaFiles;
    }

    public void sortByFileType(){
        mediaList.sort(Comparator.comparing(MediaFile::getFileType));
    }

    public void sortByFileName(){
        mediaList.sort(Comparator.comparing(MediaFile::getFileName));
    }

    public int getNumberOfFiles(){
        return mediaList.size();
    }

    public float getTotalListSize(){
        return mediaList.stream().map(mediaFile -> mediaFile.getSize()).reduce(0.0f, (a,b) -> a+b);
    }

}
