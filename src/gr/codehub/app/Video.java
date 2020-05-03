package gr.codehub.app;

import java.util.Arrays;
import java.util.Date;

public class Video extends MediaFile {
    private final float duration;
    private String producer;
    private Date dateCreated;

    // Constructor
    public Video(String fileName, float size, String fileType, float duration) {
        super(fileName, size, fileType);
        this.duration = duration;
    }

    public Video(String fileName, float size, String fileType, String creator,
                 float duration, String description) {
        super(fileName, size, fileType, creator, description);
        this.duration = duration;
    }

    public Video(String fileName, float size, String fileType, float duration,
                 String producer) {
        super(fileName, size, fileType);
        this.duration = duration;
        this.producer = producer;
    }

    public Video(String fileName, float size, String fileType, String creator,
            String description, Date dateCreated, float duration, String producer) {
        super(fileName, size, fileType, creator, description);
        this.duration = duration;
        this.producer = producer;
        this.dateCreated = dateCreated;
    }

    // Getter
    public String getMediaType(){
        return "video";
    }

    public float getDuration() {
        return duration;
    }

    public String getProducer() {
        return producer;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Setter
    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + super.getId() +
                ", fileName='" + super.getFileName() + '\'' +
                ", size=" + super.getSize() +
                ", fileType='" + super.getFileType() + '\'' +
                ", creator='" + super.getCreator() + '\'' +
                ", description=" + super.getDescription() +
                ", dateAdded='" + super.getDateAdded() + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", duration=" + duration +
                ", producer='" + producer + '\'' +
                '}';
    }
}
