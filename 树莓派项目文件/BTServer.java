import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import java.io.IOException;
import java.io.InputStream;

public class BTServer implements Runnable {

    // 流连接通知 用于创建流连接
    private StreamConnectionNotifier myPCConnNotifier = null;
    // 流连接
    private StreamConnection streamConn = null;
    // 接受数据字节流
    private byte[] acceptedByteArray = new byte[12];
    // 读取（输入）流
    private InputStream inputStream = null;

    /**
     * 主线程
     *
     * @param args
     */
    public static void main(String[] args) {
        new BTServer();
    }

    /**
     * 构造方法
     */
    public BTServer() {
        try {
            // 得到流连接通知，下面的UUID必须和手机客户端的UUID相一致。
            myPCConnNotifier = (StreamConnectionNotifier) Connector
                    .open("btspp://localhost:1000110100001000800000805F9B34FB");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 打开连接通道并读取流线程
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            String inSTR = null;
            // 持续保持着监听客户端的连接请求
            while (true) {
                // 获取流连接
                streamConn = myPCConnNotifier.acceptAndOpen();
                // 获取流通道
                inputStream = streamConn.openInputStream();
                // 读取字节流
                while (inputStream.read(acceptedByteArray) != -1) {
                    inSTR = new String(acceptedByteArray);
                    System.out.println(inSTR);
                    if (inSTR.contains("EXIT")) {
                        // 手机客户端退出则关闭连接通道。
                        inputStream.close();
                        if (streamConn != null) {
                            streamConn.close();
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}