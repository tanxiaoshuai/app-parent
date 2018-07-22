package cn.wodesh.exception;

import cn.wodesh.config.ResultInfo;

/**
 * Created by TS on 2018/7/19.
 */
public class FileException extends FinalException {

    public FileException(String code, String msg) {
        super(code, msg);
    }

    public FileException(ResultInfo e) {
        super(e);
    }
}
