package cn.wodesh;

import cn.wodesh.mapper.user.UserMapper;
import cn.wodesh.mongodb.MongoBaseDao;
import cn.wodesh.redis.RedisUtil;
import cn.wodesh.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMserverApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MongoBaseDao mongoBaseDao;

    @Test
    public void contextLoads() throws Exception {
//        User user = new User();
////        user.setId(KeyUtil.uuid());
////        userMapper.insert(user);
//        user.setTel("13088094976");
//        user.setPassword("123456");
//        System.out.println(userService.login(user));
//        userMapper.selectByPrimaryKey("e1cc065db37f489aadf56bebcdd125a5");

//        SendSmsResponse sendSmsResponse = SmsSendMessage.sendSms("18380483924" ,
//                new StringBuffer().append("{\"code\": \"").append("123456").append("\"}").toString() , "SMS_126875012");
//


    }

}
