package cn.wodesh.async;

import cn.wodesh.mapper.FileDataMapper;
import cn.wodesh.model.FileData;
import cn.wodesh.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by TS on 2018/7/16.
 */
@Component
@EnableAsync
public class FileAsync {

    @Autowired
    private ImageUtil imageUtil;
    @Autowired
    private FileDataMapper fileDataMapper;

    @Async
    public void fileCreateKeyForm(String path, int width , int height, Integer type , FileData fileData) {

    }
}