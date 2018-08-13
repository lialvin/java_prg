package qitown.s2sh.service;
import qitown.s2sh.model.User; 
import java.io.Serializable;

public interface UserServiceI {
 /**
  * 测试方法
 */
  void test();
  /**
   * 保存用户
   * @param user
   * @return
  */
  Serializable save(User user); 
  
}

