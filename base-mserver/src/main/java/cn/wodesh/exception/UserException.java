package cn.wodesh.exception;

import cn.wodesh.config.ResultInfo;

public class UserException extends FinalException{

    public UserException(String code, String msg) {
        super(code, msg);
    }

    public UserException(ResultInfo e) {
        super(e);
    }
}
