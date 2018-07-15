package cn.wodesh.services;

import cn.wodesh.model.User;

public interface IUserService {

    /**
     * 用户登录接口
     * @param user
     * @return
     * @throws Exception
     */
    Object login(User user) throws Exception;

    /**
     * 用户注册
     * @param user
     * @return
     * @throws Exception
     */
    Object register(User user) throws Exception;

    /**
     * 根据token获取用户
     * @return
     */
    Object findTokenByUser();

    /**
     * 统计在线人数
     * @return
     */
    Object findLineUsers();


}
