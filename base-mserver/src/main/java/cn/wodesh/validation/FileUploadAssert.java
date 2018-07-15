package cn.wodesh.validation;

import cn.wodesh.entity.FileSource;
import cn.wodesh.util.BeanFactoryUtil;
import com.alibaba.fastjson.JSONArray;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

/**
 * Created by TS on 2018/7/15.
 */
public class FileUploadAssert {

    public static Integer checkFile(String contentType) throws Exception {
        FileSource fileSource = BeanFactoryUtil.getBeanByClass(FileSource.class);
        Integer type = 0;
        contentType = contentType.toLowerCase();
        System.out.println(JSONArray.toJSON(fileSource.getImages()));
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
}
