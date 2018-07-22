package cn.wodesh.validation;

import cn.wodesh.util.DateUtil;

import java.util.zip.DataFormatException;

/**
 * Created by TS on 2018/7/22.
 */
public class DateAssert {

    public static void checkDateFormat(String dt , String p) throws DataFormatException {
        if (!DateUtil.isDateForm(dt , p))
            throw new DataFormatException(new StringBuffer().append("时间格式错误 仅支持").append(p).toString());
    }
}
