package cn.wodesh.util;

import org.apache.tomcat.util.http.fileupload.FileUploadException;

import java.io.*;

/**
 * Created by TS on 2018/7/15.
 */
public class FileUtil {

    /**
     * 文件流转换成文件
     * @param inputStream
     * @param path
     * @throws Exception
     */
    public static void InputStreamToFile(InputStream inputStream , String path) throws Exception {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            int readBytes = 0;
            byte[] buffer = new byte[2048];
            while ((readBytes = inputStream.read(buffer, 0, 2048)) != -1) {
                fileOutputStream.write(buffer, 0, readBytes);
            }
        } catch (FileNotFoundException e) {
            throw new NullPointerException("文件路径不存在");
        }catch (IOException e) {
            throw new FileUploadException("文件上传失败");
        }finally {
            if (inputStream != null)
                inputStream.close();
            if (fileOutputStream != null)
                fileOutputStream.close();
        }
    }
}
