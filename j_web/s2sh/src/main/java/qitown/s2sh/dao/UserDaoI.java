package qitown.s2sh.dao;
import java.io.Serializable;
import qitown.s2sh.model.User;

public interface UserDaoI {
	

	
	/**
     * �����û�
    * @param user
     * @return
     */
    Serializable save(User user);
}


