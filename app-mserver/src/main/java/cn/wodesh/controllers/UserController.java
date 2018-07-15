package cn.wodesh.controllers;

import cn.wodesh.model.User;
import cn.wodesh.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/user/login")
    public Object login(@RequestBody User user) throws Exception{
        return userService.login(user);
    }

    /**
     * 根据token获取用户
     * @return
     * @throws Exception
     */
    @GetMapping("/user/findTokenByUser")
    public Object findTokenByUser() throws Exception{
        return userService.findTokenByUser();
    }

    @GetMapping("/user/userLineCount")
    public Object findByLineUserCount(){
        return userService.findLineUsers();
    }

}
