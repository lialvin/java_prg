package qitown.testapp3;

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
		String str = "helloworld";	
		String str2 = "helloworld";	
		String str3 = "helloworld";
		/*
		 * java在编译的时候做了一个优化
		 * 若计算两边的内容都是字面量，则
		 * 会进行计算，将结果生成到编译后的
		 * 字节码文件中，所以在字节码文件中
		 * 我们看到的是如下内容:
		 * String str4 = "helloworld";
		 */
		
		UserServiceI  ab= new UserServiceImpl();
		
		String str4 = "hello"+"world";
		String a = "hello";
		String str5 = a + "world";
		
		//true
		System.out.println(str == str2);
		//true
		System.out.println(str == str3);
		//true
		System.out.println(str == str4);
		//false
		System.out.println(str == str5);
		boolean b= str.equals(str5);
		
		String s1 = "123abc";
		String s2 = 123 + "abc";
		String s3 = 1+"2"+3+"abc";
		String s4 = 1+2+"3"+"abc";
		String s5 = '1'+2+"3"+"abc";
		String s6 = "1"+'2'+3+"abc";
		//true
		System.out.println(s1==s2);
		//true
		System.out.println(s1==s3);
		//false
		System.out.println(s1==s4);
		//false
		System.out.println(s5);
		System.out.println(s1==s5);
		//true
		System.out.println(s1==s6);
		
	// TODO, add your application code
		System.out.println("Hello World!");
    }
}