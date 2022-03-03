public class CreateFileSystemResult implements Serializable, Cloneable {

    // private String ownerId;
    // private String creationToken;
    // private String fileSystemId;
    // private java.util.Date creationTime;
    // private String lifeCycleState;
    // private String name;
    // private Integer numberOfMountTargets;
    // private FileSystemSize sizeInBytes;

    
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerId() {
        return this.ownerId;
    }

    public void setCreationToken(String creationToken) {
        this.creationToken = creationToken;
    }
    public String getCreationToken() {
        return this.creationToken;
    }

    // public CreateFileSystemResult withCreationToken(String creationToken) {
    //     setCreationToken(creationToken);
    //     return this;
    // }

    // public void setFileSystemId(String fileSystemId) {
    //     this.fileSystemId = fileSystemId;
    // }
    // public String getFileSystemId() {
    //     return this.fileSystemId;
    // }
}