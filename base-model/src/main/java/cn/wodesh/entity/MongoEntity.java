package cn.wodesh.entity;

/**
 * Created by TS on 2018/7/15.
 */
public class MongoEntity <T>{

    private T data;

    private String startTime;

    private String endTime;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
