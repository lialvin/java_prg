package qitown.testapp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����Ӧ�ó���
 * @author Administrator
 * 
 */
public class Server {
	//�����ڷ���˵�Socket
	private ServerSocket server;
	/**
	 * ���췽�������ڳ�ʼ�������
	 * @throws IOException 
	 */
	public Server() throws IOException{
		try {
			/*
			 * ����ServerSocketʱ��Ҫָ������˿�
			 */
			System.out.println("��ʼ�������");
			server = new ServerSocket(8088);
			System.out.println("����˳�ʼ�����");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * ����˿�ʼ�����ķ���
	 */
	public void start(){
		try{
			/*
			 * ServerSocket��accept����
			 * ���ڼ���8088�˿ڣ��ȴ��ͻ��˵�����
			 * �÷�����һ������������ֱ��һ��
			 * �ͻ������ӣ�����÷���һֱ������
			 * ��һ���ͻ��������ˣ��᷵�ظÿͻ��˵�
			 * Socket
			 */
			System.out.println("�ȴ��ͻ�������...");
			Socket socket = server.accept();
			/*
			 * ͨ��socket��ȡԶ�˵ĵ�ַ��Ϣ
			 * ���ڷ���˶��ԣ�Զ�˾��ǿͻ�����
			 */
			InetAddress address 
				= socket.getInetAddress();
			//��ȡԶ�˼������IP��ַ
			String ha = address.getHostAddress();
//			address.getCanonicalHostName()
			//��ȡ�ͻ��˵Ķ˿ں�
			int port = socket.getPort();
			System.out.println(
							ha+":"+port+" �ͻ���������");
			
			/*
			 * ͨ���ո����ϵĿͻ��˵�Socket��ȡ
			 * ������������ȡ�ͻ��˷��͹�������Ϣ
			 */
			InputStream in 
				=	socket.getInputStream();
			/*
			 * ���ֽ���������װΪ�ַ������������
			 * ����ָ�����뼯����ȡÿһ���ַ�
			 */
			InputStreamReader isr
				= new InputStreamReader(
											in,"UTF-8");
			/*
			 * ���ַ���ת��Ϊ�����ַ�������
			 * �����Ϳ�������Ϊ��λ��ȡ�ַ����� 
			 */
			BufferedReader br
				= new BufferedReader(isr);
			
			String message = null;
			//��ȡ�ͻ��˷��͹�����һ���ַ���
			/*
			 * ��ȡ�ͻ��˷��͹�������Ϣ����
			 * windows��linux����һ���Ĳ���:
			 * linux:���ͻ��������˶Ͽ����Ӻ�
			 *       ����ͨ�����������ȡ��null
			 *       �����ǺϺ��߼��ģ���Ϊ��������
			 *       readLine()����������null��
			 *       ��ʾ�޷�ͨ�������ٶ�ȡ����Ϣ��
			 *       �ο�֮ǰ�����ı��ļ����жϡ�
			 *       
			 * windows:���ͻ��������˶Ͽ����Ӻ�
			 *         readLine()�������׳��쳣��      
			 */
			while((message = br.readLine())!=null){
				System.out.println(
						"�ͻ���˵:" + message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server server;
		try {
			server = new Server();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����˳�ʼ��ʧ��");
		}
		
	}
}






