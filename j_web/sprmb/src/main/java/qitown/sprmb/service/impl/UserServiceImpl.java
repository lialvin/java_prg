package qitown.sprmb.service.impl;

import java.util.List;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;  
import qitown.sprmb.mapper.UserMapper;
import qitown.sprmb.pojo.User;
import qitown.sprmb.pojo.UserExample;
import qitown.sprmb.pojo.UserExample.Criteria;
import qitown.sprmb.service.UserService; 

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger  
            .getLogger(UserServiceImpl.class);  
    
	@Autowired
	UserMapper userMapper;
	@Override
	public List<User> findAll() {

		LOGGER.info("findAll  result = " );  
		UserExample example = new UserExample();
		List<User> list=	userMapper.selectByExample(example);
		return list;
	}
	@Override
	public User findById(Integer idUser) {
		User user =	userMapper.selectByPrimaryKey(idUser);

		return user;
	}
	@Override
	public void update(User user) {

		int i =userMapper.updateByPrimaryKey(user);

	}
	@Override
	public void deleteById(Integer iduser) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(iduser);
	}
	@Override
	public void insert(User user) {
		userMapper.insert(user);

	}

}
