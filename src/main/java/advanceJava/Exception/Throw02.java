package advanceJava.Exception;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-03-14 16:32
 **/

// 自定义异常
// 一般自定义异常都继承于RuntimeException：可以使用默认的处理机制。
// throws 方法后，返回异常类型
// throw 手动生成异常的关键字，方法体中，返回异常对象。

public class Throw02 {
    public static void main(String[] args) {
        System.out.println("输入您的年龄：");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if(age < 18 || age > 120){
            // 通过构造器指定信息。
            throw new customException("年龄需要在18到120之间");
        }
        System.out.println("正确");
    }
}


class customException extends RuntimeException{
    public customException(String message){
        super(message);
    }
}
