package cn.wodesh.validation;

import cn.wodesh.exception.TokenParamException;

public class TokenAssert extends Assert{

    /**
     * token 非空判断
     * @param token
     */
    public static void tokenIsNotNull(String token) throws Exception {
        Assert.notNull(token , "未授权" , TokenParamException.class);
    }

}
