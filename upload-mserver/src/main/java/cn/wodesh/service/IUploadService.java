package cn.wodesh.service;

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
    Object upload(MultipartFile multipartFile) throws Exception;
}
