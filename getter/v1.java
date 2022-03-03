public class CreateFileSystemResult implements Serializable, Cloneable {


    // private String ownerId;
    // private String creationToken;
    // private String fileSystemId;
    // private java.util.Date creationTime;
    // private String lifeCycleState;
    // private String name;
    // private Integer numberOfMountTargets;
    // private FileSystemSize sizeInBytes;
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    

    public String getCreationToken() {
        return creationToken;
    }
    
    public void setCreationToken(String creationToken) {
        this.creationToken = creationToken;
    }

    // public CreateFileSystemResult withCreationToken(String creationToken) {
    //     this.creationToken = creationToken;
    //     return this;
    // }

    // public String getFileSystemId() {
    //     return fileSystemId;
    // }

    // public void setFileSystemId(String fileSystemId) {
    //     this.fileSystemId = fileSystemId;
    // }
}