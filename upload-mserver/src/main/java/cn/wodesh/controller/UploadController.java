package cn.wodesh.controller;

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
    public Object upload(@RequestParam("file") MultipartFile multipartFile , String data) throws Exception{
        return uploadService.upload(multipartFile);
    }
}
