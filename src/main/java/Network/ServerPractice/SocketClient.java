package Network.ServerPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Chris Yang
 * created 2022-06-10 15:52
 **/

public class SocketClient {
    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("127.0.0.1", 5200);
            System.out.println("client start ...");
            //向本机的52000端口发出客户请求
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //由系统标准输入设备构造BufferedReader对象
            PrintWriter write = new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输出流，并构造PrintWriter对象
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            String readline;
            readline = br.readLine(); //从系统标准输入读入一字符串
            while (!readline.equals("end")) {
                //若从标准输入读入的字符串为 "end"则停止循环
                write.println(readline);
                //将从系统标准输入读入的字符串输出到Server
                write.flush();
                //刷新输出流，使Server马上收到该字符串
                System.out.println("Client:" + readline);
                //在系统标准输出上打印读入的字符串
                System.out.println("Server:" + in.readLine());
                //从Server读入一字符串，并打印到标准输出上
                readline = br.readLine(); //从系统标准输入读入一字符串
            } //继续循环
            write.close(); //关闭Socket输出流
            in.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);//出错，打印出错信息
        }
    }
}


