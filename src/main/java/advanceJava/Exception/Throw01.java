package advanceJava.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Chris Yang
 * created 2022-03-14 16:14
 **/


public class Throw01 {
    public static void main(String[] args) throws FileNotFoundException {
        f3();
    }

    public static void f1() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("");
    }

    public static void f2() throws FileNotFoundException /*throws ArithmeticException */{
        int n = 10;
        int n2 = 0;
        double res = n/n2;
        f3(); // 调用f3也会有编译异常
    }

    public static void f3() throws RuntimeException, FileNotFoundException {
        FileInputStream fis = new FileInputStream("");
    }

    public static void f4(){
        f5(); // 调用的f5异常是运行异常，不一定要处理，会有默认的处理。
    }

    public static void f5() throws ArithmeticException{

    }
}

class Father{
    public void method() throws RuntimeException{

    }
}

class Son extends Father{
    @Override
    // 父类异常的子类型
    public void method() throws NullPointerException{

    }
}
