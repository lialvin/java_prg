package qitown.sprmvc.shop.test.service;

import java.util.Date;  
import java.util.List;
  
import qitown.sprmvc.shop.entity.UserInfo;
import qitown.sprmvc.shop.service.UserInfoService;
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
 * http://localhost:8080/sprmvc/user/showInfo/1.htmls
 * http://localhost:8080/sprmvc/user/showInfos.htmls
 */  
//   
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })  
public class TestUserInfoService {  
  
    private static final Logger LOGGER = Logger  
            .getLogger(TestUserInfoService.class);  
    @Autowired  
    private UserInfoService userInfoService;  
  
    @Test  
    public void testGetById() {  
        // 
        UserInfo userInfo = userInfoService.getById(1);  
        LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                "yyyy-MM-dd HH:mm:ss"));  
    }  
  
    @Test  
    public void testFindAll() {  
        //
        List<UserInfo> userInfos = userInfoService.findAll();  
        for (UserInfo userInfo : userInfos) {  
            LOGGER.info(JSON.toJSONStringWithDateFormat(userInfo,  
                    "yyyy-MM-dd HH:mm:ss"));  
        }  
    }  
  
    @Test  
    public void testSave() {  
        //  
        UserInfo userInfo = new UserInfo();  
        userInfo.setUname("xiaohonghong");  
        userInfo.setUnumber(5);  
        userInfo.setuRegisterTime(new Date());  
        int result = userInfoService.save(userInfo);  
        LOGGER.info("result = " + result);  
    }  
}  