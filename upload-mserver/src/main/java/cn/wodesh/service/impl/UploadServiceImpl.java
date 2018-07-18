package cn.wodesh.service.impl;

import cn.wodesh.config.FileSource;
import cn.wodesh.entity.Header;
import cn.wodesh.mapper.FileDataMapper;
import cn.wodesh.model.FileData;
import cn.wodesh.service.IUploadService;
import cn.wodesh.util.*;
import cn.wodesh.validation.FileUploadAssert;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Map;

/**
 * Created by TS on 2018/7/15.
 */
@Service
public class UploadServiceImpl implements IUploadService{

    @Autowired
    private FileSource fileSource;
    @Autowired
    private FileDataMapper fileDataMapper;
    @Autowired
    private ImageUtil imageUtil;

    /**
     * 上传文件
     * @param multipartFile
     * @param keyFormSize 首帧尺寸
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public Object upload(MultipartFile multipartFile , String keyFormSize) throws Exception {
        FileData fileData = null;
        String file_path = null;
        String keyform_path = null;
        int keyFormHeight , keyFormWidth = 0;

        if(!StringUtils.isEmpty(keyFormSize)){
            String arr[] = keyFormSize.split("[*]");
            keyFormHeight = Integer.parseInt(arr[0].trim());
            keyFormWidth = Integer.parseInt(arr[1].trim());
        }else {
            keyFormHeight = fileSource.getKeyFormHeight();
            keyFormWidth = fileSource.getKeyFormWidth();
        }
        try {
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
            file_path = path.toString();
            //写文件
            FileUtil.InputStreamToFile(multipartFile.getInputStream() , path.toString());
            //组装url
            String url = new StringBuffer().append(fileSource.getUrlType()).append("://")
                    .append(fileSource.getUrl()).append("/").append(filePath).append("/").append(DateUtil.currentTime(DateUtil.HHMMSS)).append("/").append(fileName).toString();
            Map<String,String> map = imageUtil.createKeyForm(path.toString() , keyFormHeight, keyFormWidth , type);
            keyform_path = map.get("path");
            Header header = RequestUtil.getHeader();
            fileData = new FileData();
            fileData.setId(KeyUtil.uuid());
            fileData.setCreateTime(DateUtil.currentTime(DateUtil.YEARTOSS));
            fileData.setFileSize(multipartFile.getSize());
            fileData.setFileType(type);
            fileData.setUrl(url);
            fileData.setStorageLocation(path.toString());
            fileData.setFileName(fileName);
            fileData.setKeyFormPath(keyform_path);
            fileData.setKeyFrom(map.get("url"));
            fileData.setUserId(TokenUtil.getTokenParam(header.getToken()).getUserid());
            fileDataMapper.insert(fileData);
        }catch (Exception e){
            File file = new File(file_path);
            file.delete();
            file = new File(keyform_path);
            file.delete();
            throw new FileUploadException("文件上传失败");
        }
        return ResultUtil.success(FilterParam.fileDtaeFilter(fileData));
    }
}
