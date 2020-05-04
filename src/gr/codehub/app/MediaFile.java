package gr.codehub.app;

import java.util.Date;
import java.util.Objects;

public abstract class MediaFile {
    private final int id;
    private String fileName;
    private final float size;
    private String fileType;
    private String creator;
    private String description;
    private final Date dateAdded;

    // Constructors
    public MediaFile(String fileName, float size, String fileType){
        this.fileName = fileName;
        this.size = size;
        this.fileType = fileType;
        id = Objects.hash(fileName, size, fileType);
        dateAdded = new Date();
    }

    public MediaFile(String fileName, float size, String fileType, String creator,
                     String description){
        this.fileName = fileName;
        this.size = size;
        this.fileType = fileType;
        id = Objects.hash(fileName, size, fileType);
        this.creator = creator;
        this.description = description;
        dateAdded = new Date();
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public float getSize() {
        return size;
    }

    public String getFileType() {
        return fileType;
    }

    public String getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    // Setters
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MediaFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", size=" + size +
                ", fileType='" + fileType + '\'' +
                ", creator='" + creator + '\'' +
                ", description=" + description +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaFile mediaFile = (MediaFile) o;
        return id == mediaFile.id &&
                Float.compare(mediaFile.size, size) == 0 &&
                Objects.equals(fileType, mediaFile.fileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, fileType);
    }
}
