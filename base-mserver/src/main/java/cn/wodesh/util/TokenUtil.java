package cn.wodesh.util;

import cn.wodesh.config.AppConfig;
import cn.wodesh.config.ResultInfo;
import cn.wodesh.entity.TokenParam;
import cn.wodesh.exception.TokenParamException;
import cn.wodesh.model.User;
import cn.wodesh.redis.RedisUtil;
import cn.wodesh.validation.TokenAssert;
import org.springframework.util.Base64Utils;

public class TokenUtil {

    /**
     * 创建token
     * @param user
     * @return
     */
    public static String createToken(User user){
        StringBuffer s = new StringBuffer();
        s.append(user.getId()).append("&");
        s.append(KeyUtil.uuid());
        s.append("&").append(RequestUtil.getHeader().getTelId());
        return Base64Utils.encodeToString(s.toString().getBytes());
    }

    /**
     * 解析token参数
     * @param token
     * @return
     */
    public static TokenParam getTokenParam(String token){
        TokenParam tokenParam = null;
        try {
            token = new String(Base64Utils.decodeFromString(token));
            tokenParam = new TokenParam();
            String [] params = token.split("&");
            tokenParam.setUserid(params[0]);
            tokenParam.setTime(params[1]);
            tokenParam.setTelId(params[2]);
        }catch (Exception e){
            throw new TokenParamException(ResultInfo.ERROR_PARAM.setMsg("token不合法"));
        }
        return tokenParam;
    }

    /**
     * token 验证
     * @param token
     * @return
     */
    public static boolean checkToken(String token) throws Exception {
        TokenAssert.tokenIsNotNull(token);
        TokenParam tokenParam = getTokenParam(token);
        RedisUtil redisUtil = BeanFactoryUtil.getBeanByClass(RedisUtil.class);
        String userKey = KeyUtil.sessionKey(tokenParam.getUserid());
        User user = (User) redisUtil.get(userKey);
        if (user == null)
            throw new TokenParamException(ResultInfo.USER_LOGIN_OUTTIME);
        String token_ = user.getToken();
        if (!token.equals(token_))
            throw new TokenParamException(ResultInfo.AUTHORIZE_ERROR);
        TokenParam tokenParam_ = getTokenParam(token_);
        if (!tokenParam_.getTelId().equals(tokenParam.getTelId()))
            throw new TokenParamException(ResultInfo.USER_OTHER_LOGIN);
        redisUtil.setExpire(userKey , AppConfig.TOKEN_OUT_TIME);
        System.out.println("当前时间" + redisUtil.getExpire(userKey));
        return true;
    }

    /**
     * 根据用户token 获取用户信息
     * @param token
     * @return
     */
    public static String tokenBySessionId(String token){
        TokenParam tokenParam = getTokenParam(token);
        return KeyUtil.sessionKey(tokenParam.getUserid());
    }

}
