package qitown.sprmvc.shop.dao;
 

import java.io.Serializable;  
import java.util.List;  
  
/** 
 *   
 *  
 * @author  
 * @version 2.2 
 *  
 * Dao
 */  
  
interface GenericDao<T, PK extends Serializable> {  
  
    T getById(PK id);  
  
    List<T> findAll();  
  
    PK save(T entity);  
}  