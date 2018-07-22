package cn.wodesh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TS on 2018/7/15.
 */
@Component
@PropertySource(value = "classpath:fileSource.properties" , encoding = "utf-8")
public class FileSource {

    @Value("${file.path}")
    private String path;

    @Value("${file.url}")
    private String url;

    @Value("${file.url.type}")
    private String urlType;

    @Value("${file.images.type}")
    private String images;

    @Value("${file.videos.type}")
    private String videos;

    @Value("${file.audios.type}")
    private String audios;

    @Value("${file.texts.type}")
    private String texts;

    @Value("${file.others.type}")
    private String others;

    @Value("${file.images.path}")
    private String imagesPath;

    @Value("${file.videos.path}")
    private String videosPath;

    @Value("${file.audios.path}")
    private String audiosPath;

    @Value("${file.texts.path}")
    private String textsPath;

    @Value("${file.others.path}")
    private String othersPath;

    @Value("${key.form.size}")
    private String keyFormSize;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public List<String> getImages() {
        return images == null ? null : Arrays.asList(images.split(","));
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos == null ? null : Arrays.asList(videos.split(","));
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public List<String> getAudios() {
        return audios == null ? null : Arrays.asList(audios.split(","));
    }

    public void setAudios(String audios) {
        this.audios = audios;
    }

    public List<String> getTexts() {
        return texts == null ? null : Arrays.asList(texts.split(","));
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public List<String> getOthers() {
        return others == null ? null : Arrays.asList(others.split(","));
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    public String getVideosPath() {
        return videosPath;
    }

    public void setVideosPath(String videosPath) {
        this.videosPath = videosPath;
    }

    public String getAudiosPath() {
        return audiosPath;
    }

    public void setAudiosPath(String audiosPath) {
        this.audiosPath = audiosPath;
    }

    public String getTextsPath() {
        return textsPath;
    }

    public void setTextsPath(String textsPath) {
        this.textsPath = textsPath;
    }

    public String getOthersPath() {
        return othersPath;
    }

    public void setOthersPath(String othersPath) {
        this.othersPath = othersPath;
    }

    public String getKeyFormSize() {
        return keyFormSize;
    }

    /**
     * 解析长宽
     * @param keyFormSize
     * @return
     */
    public int[] getKeyFormSizes(String keyFormSize){
        String arr[] = keyFormSize.split("[*]");
        int keyFormHeight = Integer.parseInt(arr[0].trim());
        int keyFormWidth = Integer.parseInt(arr[1].trim());
        return new int[]{keyFormHeight , keyFormWidth};
    }

    /**
     * 根据类型返回文件对应文件夹
     * @param type
     * @return
     */
    public String getFilePath(Integer type){
        if (type == 1)
            return imagesPath;
        if (type == 2)
            return textsPath;
        if (type == 3)
            return videosPath;
        if (type == 4)
            return audiosPath;
        if (type == 5)
            return othersPath;
        return null;
    }
}
