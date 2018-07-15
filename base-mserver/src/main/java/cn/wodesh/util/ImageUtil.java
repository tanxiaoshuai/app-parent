package cn.wodesh.util;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

/**
 * Created by TS on 2018/1/22.
 */
public class ImageUtil {

        private Logger log = LoggerFactory.getLogger(getClass());

        public static String SUFFIX = "keyfrom";

        /**
         * @param fromFileStr
         *            缩略图片保存路径
         */

        public static String createThumbnail(InputStream input , String fromFileStr , int width, int height) throws Exception {
            // fileExtNmae是图片的格式 gif JPG 或png
            // String fileExtNmae="";
            String [] keyfrom = fromFileStr.split("[.]");
            StringBuffer bu = new StringBuffer();
            bu.append(keyfrom[0]);
            bu.append("_");
            bu.append(SUFFIX);
            bu.append(".");
            bu.append(keyfrom[1]);

            File ThF = new File(bu.toString());
            BufferedImage buffer = ImageIO.read(input);
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
                ImageIO.write(buffer, keyfrom[1], ThF);
            } catch (Exception ex) {
                throw new Exception(" ImageIo.write error in CreatThum.: "
                        + ex.getMessage());
            }
            return bu.toString();
        }


    public static String createThumbnail(BufferedImage buf, int width, int height , String path) throws Exception {
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
     * @param videofile  源视频文件路径
     * @throws Exception
     */
    public static String fetchFrame(String videofile, int width , int height)
            throws Exception {
        long start = System.currentTimeMillis();
        String [] keyfrom = videofile.split("[.]");
        StringBuffer bu = new StringBuffer();
        bu.append(keyfrom[0]);
        bu.append("_");
        bu.append(SUFFIX);
        bu.append(".jpg");

        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
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
        ImageUtil.createThumbnail(f.image.getBufferedImage() , width , height , bu.toString());
        ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
        return bu.toString();
    }
}
