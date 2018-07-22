package cn.wodesh.controller;

import cn.wodesh.entity.Page;
import cn.wodesh.model.FileData;
import cn.wodesh.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by TS on 2018/7/15.
 */
@RestController
@RequestMapping("/rest")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @PostMapping("/upload")
    public Object upload(MultipartFile file , String keyFormSize) throws Exception{
        return uploadService.upload(file , keyFormSize);
    }

    @PostMapping("/search/page")
    public Object findByUserIdPage(@RequestBody Page<FileData> page) throws Exception {
        return uploadService.findByUserIdPage(page);
    }
}
