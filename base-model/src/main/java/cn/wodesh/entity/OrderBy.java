package cn.wodesh.entity;

/**
 * Created by TS on 2018/7/22.
 */
public class OrderBy {


    private String param;

    private String type = "DESC";

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getType() {
        return type.toUpperCase().trim();
    }

    public void setType(String type) {
        this.type = type.toUpperCase().trim();
    }
}
