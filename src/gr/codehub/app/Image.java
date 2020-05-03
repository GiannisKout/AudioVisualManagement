package gr.codehub.app;

import java.util.Arrays;
import java.util.Date;

public class Image extends MediaFile{
    private Date dateCreated;


    public Image(String fileName, float size, String fileType) {
        super(fileName, size, fileType);
    }

    public Image(String fileName, float size, String fileType, Date dateCreated) {
        super(fileName, size, fileType);
        this.dateCreated = dateCreated;
    }

    public Image(String fileName, float size, String fileType, String creator,
                 String description, Date dateCreated) {
        super(fileName, size, fileType, creator, description);
        this.dateCreated = dateCreated;
    }

    public String getMediaType(){
        return "image";
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + super.getId() +
                ", fileName='" + super.getFileName() + '\'' +
                ", size=" + super.getSize() +
                ", fileType='" + super.getFileType() + '\'' +
                ", creator='" + super.getCreator() + '\'' +
                ", description=" + super.getDescription() +
                ", dateAdded='" + super.getDateAdded() + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
