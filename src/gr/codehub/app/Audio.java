package gr.codehub.app;

import java.util.Arrays;
import java.util.Date;

public class Audio extends MediaFile{
    private final float duration;
    private Date dateCreated;
    private String singer;

    // Constructor
    public Audio(String fileName, float size, String fileType, float duration) {
        super(fileName, size, fileType);
        this.duration = duration;
    }

    public Audio(String fileName, float size, String fileType, String creator,
                 float duration, String description) {
        super(fileName, size, fileType, creator, description);
        this.duration = duration;
    }

    public Audio(String fileName, float size, String fileType, float duration,
                 String singer) {
        super(fileName, size, fileType);
        this.duration = duration;
        this.singer = singer;
    }

    public Audio(String fileName, float size, String fileType, String creator,
                 String description, Date dateCreated, float duration, String singer) {
        super(fileName, size, fileType, creator, description);
        this.duration = duration;
        this.singer = singer;
        this.dateCreated = dateCreated;
    }

    // Getter
    public String getMediaType(){
        return "audio";
    }

    public float getDuration() {
        return duration;
    }

    public String getSinger() {
        return singer;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Setter
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + super.getId() +
                ", fileName='" + super.getFileName() + '\'' +
                ", size=" + super.getSize() +
                ", fileType='" + super.getFileType() + '\'' +
                ", creator='" + super.getCreator() + '\'' +
                ", description=" + super.getDescription() +
                ", dateAdded='" + super.getDateAdded() + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", duration=" + duration +
                ", singer='" + singer + '\'' +
                '}';
    }

}
