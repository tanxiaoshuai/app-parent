package cn.wodesh.exception;

import cn.wodesh.config.ResultInfo;

public class TokenParamException extends FinalException{

    public TokenParamException() {
    }

    public TokenParamException(String code, String msg) {
        super(code, msg);
    }

    public TokenParamException(ResultInfo e) {
        super(e);
    }
}
