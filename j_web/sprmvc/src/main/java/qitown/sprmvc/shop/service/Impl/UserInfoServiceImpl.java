package qitown.sprmvc.shop.service.Impl;

import java.util.List;  
  
import qitown.sprmvc.shop.dao.UserInfoDao;
import qitown.sprmvc.shop.entity.UserInfo;
import qitown.sprmvc.shop.service.UserInfoService;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;  
  
/** 
 *  
 *  
 * @author andy 
 * @version 2.2 ʵ�ֽӿ� 
 */  
@Service("userInfoService")   
public class UserInfoServiceImpl implements UserInfoService {  
  
    @Autowired  
    private UserInfoDao userInfoDao;  
  
    @Override  
    public UserInfo getById(Integer id) {  
        return userInfoDao.getById(id);  
    }  
  
    @Override  
    public List<UserInfo> findAll() {  
        return userInfoDao.findAll();  
    }  
  
    @Override  
    public Integer save(UserInfo userInfo) {  
        return userInfoDao.save(userInfo);  
    }  
  
}  