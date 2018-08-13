package qitown.sprmvc.shop.controller;

import java.util.List;
  
import qitown.sprmvc.shop.entity.UserInfo;

import qitown.sprmvc.shop.service.UserInfoService;  
import org.apache.log4j.Logger;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;  
  
/** 
 *  2015-2-1  9:40:03 
 * @author andy 
 * @version 2.2 
 *  
 * http://localhost:8080/sprmvc/user/showInfo/1.htmls
 * http://localhost:8080/sprmvc/user/showInfos.htmls
 * userInfo  
 */  
@Controller  
@RequestMapping("/user")  
public class UserInfoController {  
  
    private static final Logger LOGGER = Logger  
            .getLogger(UserInfoController.class);  
    @Autowired  
    private UserInfoService userInfoService;  
  
    /** 
     *  定向到页面
     *  
     */
    @RequestMapping("/showInfo/{userId}")  
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {  
        LOGGER.info("qitown find user " + userId);  
        UserInfo userInfo = userInfoService.getById(1);  
        modelMap.addAttribute("userInfo", userInfo);  
        return "/user/showInfo";  
    }  
  /** 
   *  通过json 方式返回
   *  
   */
    @RequestMapping("/showInfos")  
    public @ResponseBody List<UserInfo> showUserInfos() {  
        LOGGER.info("qitown  json return all user");  
        List<UserInfo> userInfos = userInfoService.findAll();  
        return userInfos;  
    }  
}  
