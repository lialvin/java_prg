package qitown.s2sh.dao.impl;

 


import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import qitown.s2sh.dao.UserDaoI;
import qitown.s2sh.model.User;
 
@Repository("userDao")
public class UserDaoImpl implements UserDaoI {
     
     /**
      * 使用@Autowired注解将sessionFactory注入到UserDaoImpl中
      */
     @Autowired
     private SessionFactory sessionFactory;
     
     @Override
     public Serializable save(User user) {
         return sessionFactory.getCurrentSession().save(user);
     }
}
