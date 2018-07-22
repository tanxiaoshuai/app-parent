package cn.wodesh.model;

/**
 * Created by TS on 2018/7/15.
 */
public class FileData extends BaseModel{

    private String id;

    //类型（1图片,2文本,3视频,4音频,5其他）
    private Integer fileType;

    private String createTime;

    //文件大小
    private Long fileSize;

    //流媒体地址
    private String url;

    //首针地址
    private String keyFrom;

    //创建人id
    private String userId;

    //资源存放位置
    private String storageLocation;

    //文件名
    private String fileName;


    //首帧存放地址
    private String keyFormPath;

    //上传人名字
    private String createName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyFrom() {
        return keyFrom;
    }

    public void setKeyFrom(String keyFrom) {
        this.keyFrom = keyFrom;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getKeyFormPath() {
        return keyFormPath;
    }

    public void setKeyFormPath(String keyFormPath) {
        this.keyFormPath = keyFormPath;
    }
}
