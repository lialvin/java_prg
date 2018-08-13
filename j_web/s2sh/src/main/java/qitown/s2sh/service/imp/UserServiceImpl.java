package qitown.s2sh.service.imp;


import  java.io.Serializable;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
 
import  qitown.s2sh.dao.UserDaoI;
import  qitown.s2sh.model.User;
import  qitown.s2sh.service.UserServiceI;

// 使用Spring提供的@Service注解将UserServiceImpl标注为一个Service 
@Service("userService")
public class  UserServiceImpl implements UserServiceI {
	/**
	     * 注入userDao
	*/
	@Autowired
	private UserDaoI userDao;
	
	@Override 	
	public void test()
    {
	    System.out.println("spring Hello World!");
	}
	

	@Override
	public Serializable save(User user) {
	    return userDao.save(user);
	}
}


