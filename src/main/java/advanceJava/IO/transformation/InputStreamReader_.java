package advanceJava.IO.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Chris Yang
 * created 2022-04-13 19:58
 **/

// InputStreamReader 可以将 InputStream(字节流）转化成 Reader（字符流）
// 在处理纯文本的时候，字符流更快,并且可以有效解决中文的问题

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "./newFile03.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "gbk"));

        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();

    }
}
