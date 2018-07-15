package cn.wodesh.service.impl;

import cn.wodesh.entity.FileSource;
import cn.wodesh.mapper.FileDataMapper;
import cn.wodesh.model.FileData;
import cn.wodesh.service.IUploadService;
import cn.wodesh.util.DateUtil;
import cn.wodesh.util.FileUtil;
import cn.wodesh.util.KeyUtil;
import cn.wodesh.util.ResultUtil;
import cn.wodesh.validation.FileUploadAssert;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

/**
 * Created by TS on 2018/7/15.
 */
@Service
public class UploadServiceImpl implements IUploadService{

    @Autowired
    private FileSource fileSource;
    @Autowired
    private FileDataMapper fileDataMapper;

    /**
     * 上传文件
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @Override
    public Object upload(MultipartFile multipartFile) throws Exception {
        String contentType = multipartFile.getOriginalFilename();
        String arr[] = contentType.split("[.]");
        if (arr.length == 0)
            throw new FileUploadException("未知文件格式不能上传");
        //文件名
        String  fileName = new StringBuffer().append(KeyUtil.uuid()).append(".").append(arr[arr.length - 1]).toString();
        //文件存放位置
        StringBuffer path = new StringBuffer().append(fileSource.getPath()).append("\\");
        //返回文件类型
        Integer type = FileUploadAssert.checkFile(arr[arr.length - 1]);
        //判断文件存放子文件夹名字
        String filePath = fileSource.getFilePath(type);
        //判断完整文件夹是否存在，不存在就创建
        path.append(filePath).append("\\").append(DateUtil.currentTime(DateUtil.HHMMSS));
        File file = new File(path.toString());
        if(!file.exists())
            file.mkdirs();
        path.append("\\").append(fileName);
        //写文件
        FileUtil.InputStreamToFile(multipartFile.getInputStream() , path.toString());
        //组装url
        String url = new StringBuffer().append(fileSource.getUrlType()).append("://")
                .append(fileSource.getUrl()).append("/").append(filePath).append("/").append(DateUtil.currentTime(DateUtil.HHMMSS)).append("/").append(fileName).toString();
        FileData fileData = new FileData();
        fileData.setId(KeyUtil.uuid());
        fileData.setCreateTime(DateUtil.currentTime(DateUtil.YEARTOSS));
        fileData.setFileSize(multipartFile.getSize());
        fileData.setFileType(type);
        fileData.setUrl(url);
        fileData.setStorageLocation(path.toString());
        fileData.setFileName(fileName);
        fileDataMapper.insert(fileData);
        return ResultUtil.success(fileData);
    }
}
