package qitown.s2sh.service.imp;


import  java.io.Serializable;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
 
import  qitown.s2sh.dao.UserDaoI;
import  qitown.s2sh.model.User;
import  qitown.s2sh.service.UserServiceI;

// ʹ��Spring�ṩ��@Serviceע�⽫UserServiceImpl��עΪһ��Service 
@Service("userService")
public class  UserServiceImpl implements UserServiceI {
	/**
	     * ע��userDao
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


