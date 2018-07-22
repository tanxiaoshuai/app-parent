package cn.wodesh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public final static String YEARTOSS_PATTERN = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|\n" +
            "((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|\n" +
            "((0[48]|[2468][048]|[3579][26])00))-02-29))\n" +
            "\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
    public final static String YEARTOSS = "yyyy-MM-dd HH:mm:ss";
    public final static String HH_MM_SS = "yyyy-MM-dd";
    public final static String YMHSS = "yyyyMMddHHmmss";
    public final static String MMSS = "mm:ss";
    public final static String HHMMSS = "yyyyMMdd";

    public static String longForTime(long s , String mat){
        SimpleDateFormat format = new SimpleDateFormat(mat);
        Date date = new Date(s);
        return format.format(date).toString();
    }

    public static String currentTime(String mat){
        SimpleDateFormat format = new SimpleDateFormat(mat);
        Date date = new Date(System.currentTimeMillis());
        return format.format(date).toString();
    }

    /**
     * 将时间模板   转化为毫秒"yyyy-MM-dd HH:mm:ss"
     * @param time
     * @return
     */
    public static long longForDate(String time , String formatStr){
        SimpleDateFormat format =  new SimpleDateFormat(formatStr);
        long dateL = 0;
        try {
            Date date = format.parse(time);
            dateL = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateL;
    }

    public static String dateFormat(String time , String oldFat , String newFat){
        long s = longForDate(time , oldFat);
        return longForTime(s , newFat);
    }

    /**
     * 判断时间格式
     * @param dt
     * @param pattern
     * @return
     */
    public static boolean isDateForm(String dt , String pattern){
        return RegexUtil.match(dt , pattern);
    }
}
