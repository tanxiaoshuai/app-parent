package cn.wodesh.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TS on 2018/7/21.
 */
public class TimeRanges {

    //开始时间
    private String startTime = currentTime("00:00:00");
    //结束时间
    private String endTime = currentTime("23:59:59");

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

    public String currentTime(String mat){
        StringBuffer time = new StringBuffer();
        time.append("yyyy-MM-dd ").append(mat.trim());
        SimpleDateFormat format = new SimpleDateFormat(time.toString());
        Date date = new Date(System.currentTimeMillis());
        return format.format(date).toString();
    }
}
