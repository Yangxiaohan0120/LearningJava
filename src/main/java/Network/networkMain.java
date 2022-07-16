package Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author Chris Yang
 * created 2022-06-10 13:57
 **/
public class networkMain {

    public void test() throws IOException {
        new Server(); // 先跑服务端
        new Client(); // 再打开客户端，两个class 就可以连接起来了

    }

    public static void main(String[] args) {
        new networkMain();
    }
}

// 服务端
class Server {

    public static void main(String[] args) throws IOException {
        // 初始化服务端，并绑定端口，监听
        ServerSocket serverSocket = new ServerSocket(9999);
        // 等待客户端的发送信息
        Socket socket = serverSocket.accept();

        // 监听流，获取客户端的消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //输出打印
        String str = null;
        while(( str = bufferedReader.readLine()) != null){
            System.out.println(str);
        };
    }
}


// 客户端
class Client {

    public static void main(String[] args) throws IOException {

        // 初始化socket
        Socket socket = new Socket("127.0.0.1", 9999);

        // 发送消息等待回应。
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        for (int i = 0; i < 20; i++) {
            String str = "你好，这是我的第" + i + "个socket";
            bufferedWriter.write(str + "\n");
        }


        bufferedWriter.flush();

        //关闭socket的输出流
        socket.shutdownOutput();
    }

}
