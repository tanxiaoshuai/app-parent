package cn.wodesh.util;
import cn.wodesh.entity.Header;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUtil {

    public static String getHeader(String s){
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest().getHeader(s);
    }

    public static Header getHeader(){
        Header header = new Header();
        header.setTelId(getHeader("telId"));
        header.setToken(getHeader("token"));
        return header;
    }
}
