package qitown.s2sh.test;

import qitown.s2sh.service.UserServiceI;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
 
     @Test
     public void test(){
         //ͨ��spring.xml�����ļ�����Spring��Ӧ�ó��������Ļ���
         //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
         /**
          *��Ϊ�Ѿ�������Hibernate��UserServiceImpl����ʹ�õ���userDao��
          *userDao����spring��������ע���UserServiceImpl��ģ���userDao����ʹ�õ���sessionFactory����
          *������sessionFactory����ʱ��Ҫʹ�õ�spring-hibernate.xml��������ļ��е���������Ϣ��
          *���Դ���Spring��Ӧ�ó��������Ļ���ʱ����Ҫͬʱʹ��spring.xml��spring-hibernate.xml�����������ļ�
          *������ִ��Maven install����ʱ����Ϊmaven����ִ��test�����еĴ��룬������ִ�е�
          *UserServiceI userService = (UserServiceI) ac.getBean("userService");
          *��һ��ʱ�ͻ���ΪuserDao��ʹ�õ�sessionFactory�����޷����������Ķ���������ִ��Maven install���������Ŀʱ�ͻ�ʧ�ܣ�
          *
          */
         ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
         //��Spring��IOC�����л�ȡbean����
         UserServiceI userService = (UserServiceI) ac.getBean("userService");
         //ִ�в��Է���
         userService.test();
     }
 }