package qitown.sprmvc.shop.service;


import java.util.List;  
import qitown.sprmvc.shop.entity.UserInfo;

  
/** 
 *  2015-1-30  11:31:34 
 *  
 * @author andy 
 * @version 2.2 
 *  
 * UserInfoService
 */  
  
public interface UserInfoService {  
  
    // ͨ��Id��ѯUserInfo  
    UserInfo getById(Integer id);  
  
    // ��ѯȫ����UserInfo  
    List<UserInfo> findAll();  
  
    // ���UserInfo  
    Integer save(UserInfo userInfo);  
  
} 