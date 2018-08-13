package qitown.sockapp;
import java.io.IOException;

import qitown.sockapp.TcpClient;
import qitown.sockapp.TcpServer;
import qitown.sockapp.UdpClient;
import qitown.sockapp.UdpServer;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static void testudp()
	{
		
		UdpClient client = new UdpClient();
		client.start();
		 	
		
		UdpServer server = new UdpServer();
		server.start();
				
	}
	static void testtcp()
	{
				  		
		Thread tid1= new Thread(new Runnable() {
			public void run(){	
				TcpServer server;
				try {
					server = new TcpServer();
					server.start();
				}
			    catch (IOException e) {
					e.printStackTrace();
					System.out.println("服务端初始化失败");
				}	
					 
			}
		});
		tid1.start();	
						 
		
		try{
			TcpClient client = new TcpClient();
			client.start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("客户端初始化失败");
		}			
	}
 
    
	public static void main(String[] args){

		testtcp();		
	}
	
	
}
