package cn.wodesh.validation;

import cn.wodesh.config.ResultInfo;
import cn.wodesh.exception.UserException;
import cn.wodesh.model.User;
import cn.wodesh.util.MD5Util;
import cn.wodesh.util.RegexUtil;
import cn.wodesh.util.RequestUtil;

public class UserAssert extends Assert {

    /**
     * 用户登陆参数合法验证
     * @param user
     */
    public static void loginCheck(User user) throws Exception {
        notNull(user.getTel() , "手机号码不能为空" , UserException.class);
        notNull(user.getPassWord() , "密码不能为空", UserException.class);
        if(!RegexUtil.isMobile(user.getTel()))
            throw new UserException(ResultInfo.ERROR_PARAM.setMsg("手机号格式错误"));
    }
    /**
     * 验证登陆信息
     * @param u1
     * @param u
     */
    public static void loginCheck(User u1 , User u){
        if (u1 == null)
            throw new UserException(ResultInfo.USER_ISNOT_EXIST);
        if(!u1.getPassWord().equals(MD5Util.MD5(u.getPassWord())))
            throw new UserException(ResultInfo.USER_PASSWORD_ERROR);
    }
    /**
     * 用户登入验证telId 不为空
     */
    public static void loginTelIdNotNull() throws Exception {
        Assert.notNull(RequestUtil.getHeader("telId") , "手机唯一标识不能为空" , UserException.class);
    }




}
