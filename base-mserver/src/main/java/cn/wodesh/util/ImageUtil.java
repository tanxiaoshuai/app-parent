package cn.wodesh.util;

import cn.wodesh.entity.FileSource;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TS on 2018/1/22.
 */

@Component
public class ImageUtil {

    @Autowired
    private FileSource fileSource;


    /**
     *            缩略图片保存路径
     */
    public String createThumbnail(String sourcePath, int width , int height , String tagerPath) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(sourcePath));
            String p = new StringBuffer().append(KeyUtil.uuid()).append(".jpg").toString();
            sourcePath = createThumbnail(ImageIO.read(fileInputStream) , width , height , tagerPath);
        }finally {
            if (fileInputStream != null)
                fileInputStream.close();
        }
        return sourcePath;
    }


    public String createThumbnail(BufferedImage buf, int width, int height , String path) throws Exception {
        File ThF = new File(path);
        BufferedImage buffer = buf;
        /*
         * 核心算法，计算图片的压缩比
         */
        int w= buffer.getWidth();
        int h=buffer.getHeight();
        double ratiox = 1.0d;
        double ratioy = 1.0d;

        ratiox= w * ratiox / width;
        ratioy= h * ratioy / height;

        if( ratiox >= 1){
            if(ratioy < 1){
                ratiox = height * 1.0 / h;
            }else{
                if(ratiox > ratioy){
                    ratiox = height * 1.0 / h;
                }else{
                    ratiox = width * 1.0 / w;
                }
            }
        }else{
            if(ratioy < 1){
                if(ratiox > ratioy){
                    ratiox = height * 1.0 / h;
                }else{
                    ratiox = width * 1.0 / w;
                }
            }else{
                ratiox = width * 1.0 / w;
            }
        }
        /*
         * 对于图片的放大或缩小倍数计算完成，ratiox大于1，则表示放大，否则表示缩小
         */
        AffineTransformOp op = new AffineTransformOp(AffineTransform
                .getScaleInstance(ratiox, ratiox), null);
        buffer = op.filter(buffer, null);
        //从放大的图像中心截图
        buffer = buffer.getSubimage((buffer.getWidth()-width)/2, (buffer.getHeight() - height) / 2, width, height);
        try {
            ImageIO.write(buffer, "jpg", ThF);
        } catch (Exception ex) {
            throw new Exception(" ImageIo.write error in CreatThum.: "
                    + ex.getMessage());
        }
        return path;
    }

    /**
     * 获取指定视频的帧并保存为图片至指定目录
     * @throws Exception
     */
    public String fetchFrame(String sourcePath, int width , int height , String tagerPath)
            throws Exception {
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(sourcePath);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }
        createThumbnail(f.image.getBufferedImage() , width , height , tagerPath);
        ff.flush();
        ff.stop();
        return tagerPath;
    }

    public Map<String , String> createKeyForm(String path, int width , int height,Integer type) throws Exception {
        Map<String , String> map = new HashMap<>();
        String time = DateUtil.currentTime(DateUtil.HHMMSS);
        String name = new StringBuffer().append(KeyUtil.uuid()).append(".jpg").toString();
        String filePath = fileSource.getFilePath(type);
        StringBuffer tagerPath = new StringBuffer().append(fileSource.getPath()).append("\\")
                            .append(filePath).append("\\").append(time).append("\\").append(name);
        StringBuffer url = new StringBuffer().append(fileSource.getUrlType()).append("://")
                .append(fileSource.getUrl()).append("/").append(filePath).append("/").append(time).append("/").append(name);
        map.put("path" , tagerPath.toString());
        map.put("url" , url.toString());
        if(1 == type)
            createThumbnail(path , width , height , tagerPath.toString());
        if(3 == type)
            fetchFrame(path , width , height , tagerPath.toString());
        return map;
    }
}
