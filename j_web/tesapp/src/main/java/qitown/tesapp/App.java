package qitown.tesapp;

/**
 * Hello world!
 *
 */
import qitown.tesapp.service.UserServiceI;
import qitown.tesapp.service.imp.*;

public class App 
{
    public static void main( String[] args )
    {
    	UserServiceI aa= new UserServiceImpl();
    	aa.test();
        System.out.println( "Hello World fist!" );
    }
}
