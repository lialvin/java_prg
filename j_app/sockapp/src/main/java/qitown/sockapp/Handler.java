package qitown.sockapp;
  
import java.io.IOException;  
import java.nio.ByteBuffer;  
import java.nio.channels.SelectionKey;  
import java.nio.channels.Selector;  
import java.nio.channels.SocketChannel;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
import qitown.sockapp.Bytes2util;  
import qitown.sockapp.Util2Bytes;  
  
final public class Handler implements Runnable  
{  
    private static Logger logger = LoggerFactory.getLogger(Handler.class);  
    final SocketChannel socket;  
    final SelectionKey sk;  
  
    static final int MESSAGE_LENGTH_HEAD = 4;  
    byte[] head = new byte[4];  
    int bodylen = -1;  
  
    Handler(Selector selector, SocketChannel socket) throws IOException  
    {  
        this.socket = socket;  
        socket.configureBlocking(false);  
        sk = socket.register(selector, 0);  
        sk.attach(this);  
        sk.interestOps(SelectionKey.OP_READ);  
        selector.wakeup();  
    }  
  
    public void run()  
    {  
        try  
        {  
            read();  
        }  
        catch (IOException ex)  
        {  
            try  
            {  
                socket.close();  
            }  
            catch (IOException e)  
            {  
                e.printStackTrace();  
            }  
            logger.info("got a disconnect from " + socket.socket().toString());  
            sk.cancel();  
        }  
    }  
  
    public synchronized void read() throws IOException  
    {  
        ByteBuffer input = ByteBuffer.allocate(1024);  
        socket.read(input);  
        input.flip();  
          
        //��ȡ���ݵ�ԭ��: Ҫô��ȡһ�������İ�ͷ��Ҫô��ȡһ���������塣���������������������ByteBuffer�����κε�get����  
        //����Ҫע����ܷ����ϴζ�ȡ��һ�������İ�ͷ���´ζ��Ŷ�ȡһ���������������  
        //���԰�ͷ���ֱ�������ĳ�Ա����������ʱ�Ĵ洢����������ȡ��ͷ�Ͱ�����ڸ�ҵ�����֡�  
        logger.debug("1: remain=" + input.remaining() + " bodylen=" + bodylen);  
        while(input.remaining() > 0)  
        {  
            if (bodylen < 0) //��û�����������İ�ͷ����, �ñ�����ʼֵΪ-1��������ƴ��һ����������Ϣ���Ժ��ٽ���ֵ����Ϊ-1  
            {  
                if ( input.remaining() >= MESSAGE_LENGTH_HEAD) //ByteBuffer���������ֽ�����ƴ��һ����ͷ  
                {  
                    input.get(head, 0, 4);  
                    bodylen = Util2Bytes.bytes2bigint(head);  
                    logger.debug("2: remain=" + input.remaining() + " bodylen=" + bodylen);  
                }  
                else//ByteBuffer���������ֽ�������ƴ��һ����ͷ��ʲô�������������˳���δ��������ȴ�  
                {  
                    logger.debug("3: remain=" + input.remaining() + " bodylen=" + bodylen);  
                    break;  
                }  
            }  
            else if(bodylen > 0) //��ͷ�����Ѿ���������.   
            {  
                if (input.remaining() >= bodylen) //�����������ݹ�һ�����岿��  
                {  
                    byte[] body = new byte[bodylen];  
                    input.get(body, 0, bodylen);  
                    byte[] headandbody = new byte[MESSAGE_LENGTH_HEAD + bodylen];  
                    System.arraycopy(head, 0, headandbody, 0, head.length);  
                    System.arraycopy(body,0, headandbody, head.length, body.length);              
                    bodylen = -1;  
                    logger.debug("4: remain=" + input.remaining() + " bodylen=" + bodylen);  
                    Bytes2util.outputHex(headandbody, 16);  
                }  
                else  ///�����������ݲ���һ�����岿�֣������ȴ�������ѭ���ȴ��´��ٳ����ú���  
                {  
                    System.out.println("5: remain=" + input.remaining() + " bodylen=" + bodylen);  
                    break;  
                }  
            }  
            else if(bodylen == 0) //û�а��岿�֣������а�ͷ�����  
            {  
                byte[] headandbody = new byte[MESSAGE_LENGTH_HEAD + bodylen];  
                System.arraycopy(head, 0, headandbody, 0, head.length);  
                Bytes2util.outputHex(headandbody, 16);  
                bodylen = -1;  
            }  
        }  
          
        sk.interestOps(SelectionKey.OP_READ);  
    }  
}  