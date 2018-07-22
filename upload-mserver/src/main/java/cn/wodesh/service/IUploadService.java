package cn.wodesh.service;

import cn.wodesh.entity.Page;
import cn.wodesh.model.FileData;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by TS on 2018/7/15.
 */
public interface IUploadService {

    /**
     * 上传文件
     * @param multipartFile
     * @return
     * @throws Exception
     */
    Object upload(MultipartFile multipartFile, String keyFormSize) throws Exception;

    Object findByUserIdPage(Page<FileData> page) throws Exception;
}
