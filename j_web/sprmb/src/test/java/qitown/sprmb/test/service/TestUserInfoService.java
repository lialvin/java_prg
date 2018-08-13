package qitown.sprmb.test.service;

import java.util.Date;  
import java.util.List;
  
import qitown.sprmb.pojo.*;
import qitown.sprmb.service.UserService;
import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
  
import com.alibaba.fastjson.JSON;  
  
/** 
 * 
 *  
 * @author andy 
 * @version 2.2 
 *  http://localhost:8080/sprmb/user/addUser
 *  http://localhost:8080/sprmb/user/list
 */  
//   
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:beans.xml" })  
public class TestUserInfoService {  
  
    private static final Logger LOGGER = Logger  
            .getLogger(TestUserInfoService.class);  
    @Autowired  
    private UserService userService;  
  
    @Test  
    public void testGetById() {  
        // 
        User userInfo = userService.findById(1);  
        LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                "yyyy-MM-dd HH:mm:ss"));  
    }  
  
    @Test  
    public void testFindAll() {  
        //
        List<User> userInfos = userService.findAll();  
        for (User userInfo : userInfos) {  
            LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                    "yyyy-MM-dd HH:mm:ss"));  
        }  
    }  
  
    @Test  
    public void testSave() {  
        //  
        User  userInfo = new User();  
        userInfo.setIduser(100 );  
        userInfo.setAvatar("sdfs");  
        userInfo.setEmail("sd");
        userInfo.setNickname("sd");
        userInfo.setPassword("sd");
        userInfo.setUsername("sd");
        userService.insert(userInfo);  
        LOGGER.info("insert result = " );  
    }  
}  