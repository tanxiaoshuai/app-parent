package cn.wodesh.validation;


import cn.wodesh.config.FileSource;
import cn.wodesh.exception.FileException;
import cn.wodesh.util.BeanFactoryUtil;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by TS on 2018/7/15.
 */
public class FileUploadAssert extends Assert{

    /**
     * 判断是否支持类型
     * @param contentType
     * @return
     * @throws Exception
     */
    public static Integer checkFile(String contentType) throws Exception {
        FileSource fileSource = BeanFactoryUtil.getBeanByClass(FileSource.class);
        Integer type = 0;
        contentType = contentType.toLowerCase();
        if (fileSource.getImages().contains(contentType))
            type = 1;
        if(fileSource.getTexts().contains(contentType))
            type = 2;
        if(fileSource.getVideos().contains(contentType))
            type = 3;
        if (fileSource.getAudios().contains(contentType))
            type = 4;
        if (fileSource.getOthers().contains(contentType))
            type = 5;
        if(type == 0)
            throw new FileUploadException(new StringBuffer().append("暂不支持上传 ").append(contentType).append(" 格式文件").toString());
        return type;
    }

    /**
     * 判断是否选择文件
     * @param multipartFile
     * @throws Exception
     */
    public static void MultipartFileNotNull(MultipartFile multipartFile) throws Exception {
        notNull(multipartFile , "请选择文件" , FileException.class);
    }
}
