package qitown.sprmvc.shop.entity;

import java.io.Serializable;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.Date;  
  
import org.springframework.jdbc.core.RowMapper;  
  
/** 
 *  
 *  
 * @author andy 
 *  
 */  
public class UserInfo implements RowMapper<UserInfo>, Serializable {  
  
    /** 
     *  
     */  
    private static final long serialVersionUID = -8823504831198719837L;  
  
    private Integer id;  
  
    private String uname;  
  
    private Integer unumber;  
  
    private Date uRegisterTime;  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getUname() {  
        return uname;  
    }  
  
    public void setUname(String uname) {  
        this.uname = uname == null ? null : uname.trim();  
    }  
  
    public Integer getUnumber() {  
        return unumber;  
    }  
  
    public void setUnumber(Integer unumber) {  
        this.unumber = unumber;  
    }  
  
    public Date getuRegisterTime() {  
        return uRegisterTime;  
    }  
  
    public void setuRegisterTime(Date uRegisterTime) {  
        this.uRegisterTime = uRegisterTime;  
    }  
  
    @Override  
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {  
        UserInfo userInfo = new UserInfo();  
        userInfo.setId(rs.getInt("id"));  
        userInfo.setUname(rs.getString("uname"));  
        userInfo.setUnumber(rs.getInt("unumber"));  
        userInfo.setuRegisterTime(rs.getDate("uregister_time"));  
        return userInfo;  
    }  
  
}  