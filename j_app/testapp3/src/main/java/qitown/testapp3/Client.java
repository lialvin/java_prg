package qitown.testapp3;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * �ͻ���Ӧ�ó���
 * @author Administrator
 *
 */
public class Client {
	//Socket���������ӷ���˵�ServerSocket
	private Socket socket;
	/**
	 * �ͻ��˹��췽�������ڳ�ʼ���ͻ���
	 * @throws Exception 
	 */
	public Client() throws Exception{	
		try {
			/*
			 * ����Socket����ʱ���ͻ᳢�Ը���
			 * �����ĵ�ַ��˿����ӷ���ˡ�
			 * ���ԣ����ö��󴴽��ɹ���˵����
			 * ���������������
			 * 
			 *
			 * 
			 */
			System.out.println("�������ӷ����...");
			socket = new Socket(
									"localhost",8088);
			System.out.println("�ɹ����ӷ����");
		} catch (Exception e) {
			throw e;
		}	
	}
	/**
	 * �ͻ�����������
	 */
	public void start(){
		try{
			/*
			 * ����ͨ��Socket��getOutputStream()
			 * ������ȡһ������������ڽ���Ϣ����
			 * �������
			 */
			OutputStream out = 
							socket.getOutputStream();
			/*
			 * ʹ���ַ���������ָ���ı��뼯���ַ���
			 * ת��Ϊ�ֽں���ͨ��out���͸������
			 */
			OutputStreamWriter osw
				= new OutputStreamWriter(
													out,"UTF-8");
			/*
			 * ���ַ�����װΪ�����ַ������Ϳ���
			 * ����Ϊ��λд���ַ�����
			 */
			PrintWriter pw 
				= new PrintWriter(osw);
			/*
			 * ����һ��Scanner�����ڽ����û�
			 * ������ַ���
			 */
			Scanner scanner 
						= new Scanner(System.in);
			while(true){
				String str = scanner.nextLine();
				pw.println(str);
				pw.flush();
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try{
			Client client = new Client();
			client.start();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�ͻ��˳�ʼ��ʧ��");
		}
	}
}


