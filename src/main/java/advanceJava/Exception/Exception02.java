package advanceJava.Exception;

import java.io.*;

/**
 * @author Chris Yang
 * created 2022-03-14 14:12
 **/

// 五大常见运行时异常

// 1. NullPointerException
// 2. ArithmeticException
// 3. ArrayIndexOutOfBoundsException
// 4. ClassCastException
// 5. NumberFormatException

// 常见的编译异常

// SQLException
// IOException
// FileNotFoundException
// ClassNotFoundException
// EOFException
// IllegalArgumentException

// 异常处理的方式：
// 1. try-catch
// 2. throws

// 3. 如果没有处理异常，默认是throws


// try-catch 细节：
// 1. try 中如果产生异常，之后的代码不再执行，直接跳转到catch
// 2. 如果没有异常，则继续进行，不执行catch
// 3. 如果希望总是执行，则放置在finally中
// 4. 可以有多个catch，捕获不同的异常，要求父类在后，子类在前，只会执行其中一个
// 5. try-finally 不捕获异常，但是一定会执行某一段命令，程序崩溃直接退出

// throws 细节：
// 并不知道该如何处理，就返回异常。
// 1) 编译异常必须处理，使用try-catch或者throws
// 2）运行异常如果没有处理，默认使用throws处理
// 3) 子类重写父类的方法时，抛出异常的规定：子类抛出的异常要么和父类的一致，要么是父类的子类。
// 4）如果在throws的代码中有try-catch，则不需要进行throw

public class Exception02 {
    public static void main(String[] args) {
        Throwable throwable = new Throwable();
        // show diagrams

        // ctl + alt + t
        // command + option + t

        try {
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File("")));
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // 如果不发生异常 catch不执行
        }finally {
            System.out.println("成功");
            // 无论如何都会执行，通常将释放资源的代码放在这里。
        }
    }
}
