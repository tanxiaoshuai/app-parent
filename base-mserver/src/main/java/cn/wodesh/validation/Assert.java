package cn.wodesh.validation;


import cn.wodesh.config.ResultInfo;
import cn.wodesh.exception.FinalException;
import cn.wodesh.util.RegexUtil;

/**
 * Created by TS on 2018/2/24.
 */
public class Assert {

    public static void notNull(String param , String msg , Class c) throws Exception {
        if(RegexUtil.isNull(param))
            throw (RuntimeException) c.getConstructor(ResultInfo.class).newInstance(ResultInfo.ERROR_PARAM.setMsg(msg));
    }

    public static void notNull(Integer param , String msg, Class c) throws Exception {
        if(RegexUtil.isNull(param))
            throw (RuntimeException) c.getConstructor(ResultInfo.class).newInstance(ResultInfo.ERROR_PARAM.setMsg(msg));
    }

    public static void notNull(Object o , String msg, Class c) throws Exception {
        if(o == null)
            throw (Exception) c.getConstructor(ResultInfo.class).newInstance(ResultInfo.ERROR_PARAM.setMsg(msg));
    }

    public static void length(int min , long max , String param , String msg){
        long len = param.length();
        if (len < min || len > max)
            throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
    }

    public static void min(int min , Object param, String msg){
        if(param instanceof String)
            if (((String) param).length() < min)
                throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
        if(param instanceof Integer)
            if ((Integer)param < min)
                throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
        if(param instanceof Long)
            if ((Long)param < min)
                throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
    }

    public static void max(int max , Object param, String msg){
        if(param instanceof String)
            if (((String) param).length() > max)
                throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
        if(param instanceof Integer)
            if ((Integer)param > max)
                throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
        if(param instanceof Long)
            if ((Long)param > max)
                throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
    }

    public static void pattern(String param , String reg , String msg){
        if(!RegexUtil.match(param , reg))
            throw new FinalException(ResultInfo.ERROR_PARAM.setMsg(msg));
    }




}
