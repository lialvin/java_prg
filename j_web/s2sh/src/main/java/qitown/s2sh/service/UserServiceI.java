package qitown.s2sh.service;
import qitown.s2sh.model.User; 
import java.io.Serializable;

public interface UserServiceI {
 /**
  * ���Է���
 */
  void test();
  /**
   * �����û�
   * @param user
   * @return
  */
  Serializable save(User user); 
  
}

