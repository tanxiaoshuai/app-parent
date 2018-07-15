package cn.wodesh.config;

/**
 * Created by TS on 2018/2/24.
 */
public enum ResultInfo {

    SUCCESS("0000","操作成功"),
    ERROR_PARAM("0001","参数错误"),
    EXCEPTION("0002","系统异常"),
    USER_ISNOT_EXIST("0003" ,"用户不存在"),
    USER_PASSWORD_ERROR("0004" , "用户密码错误"),
    USER_LOGIN_OUTTIME("0005","登陆超时"),
    USER_OTHER_LOGIN("0006" , "用户已在其他设备上登陆"),
    AUTHORIZE_ERROR("0007" , "授权失败"),

    ;

    private String code;

    private String msg;

    ResultInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public ResultInfo setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultInfo setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
