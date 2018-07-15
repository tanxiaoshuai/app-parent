package cn.wodesh.services.impl;

import cn.wodesh.config.AppConfig;
import cn.wodesh.entity.Header;
import cn.wodesh.mapper.user.UserMapper;
import cn.wodesh.model.User;
import cn.wodesh.redis.RedisUtil;
import cn.wodesh.services.IUserService;
import cn.wodesh.util.KeyUtil;
import cn.wodesh.util.RequestUtil;
import cn.wodesh.util.ResultUtil;
import cn.wodesh.util.TokenUtil;
import cn.wodesh.validation.UserAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object login(User user) throws Exception {
        UserAssert.loginTelIdNotNull();
        UserAssert.loginCheck(user);
        User us = userMapper.login(user.getTel());
        UserAssert.loginCheck(us , user);
        us.setPassWord(null);
        us.setToken(TokenUtil.createToken(us));
        redisUtil.set(KeyUtil.sessionKey(us.getId()) ,us, AppConfig.TOKEN_OUT_TIME);
        return ResultUtil.success(us);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Object register(User user) throws Exception {
        return null;
    }

    /**
     * 根据token获取用户
     * @return
     */
    @Override
    public Object findTokenByUser() {
        Header header = RequestUtil.getHeader();
        User user = (User) redisUtil.get(TokenUtil.tokenBySessionId(header.getToken()));
        return ResultUtil.success(user);
    }

    /**
     * 统计在线人数
     * @return
     */
    @Override
    public Object findLineUsers() {
        return ResultUtil.success(redisUtil.size(AppConfig.APP_USER).size());
    }

}
