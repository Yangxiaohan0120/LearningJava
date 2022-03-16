package advanceJava.Exception;

/**
 * @author Chris Yang
 * created 2022-03-14 14:00
 **/

// 程序执行过程中的不正常情况为"异常"，语法错误和逻辑错误不是异常。

// error ： JVM系统内部错误、资源耗尽等严重情况
//    StackOverflowError[栈溢出]  OOM[out of memory]

// Exception： 其他因编程错误或偶然的外在因素导致的一般性问题使用针对性代码进行处理
//    空指针访问、读取不存在的文件、网络连接中断
//    运行时异常和编译时异常

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        int res = 0;
        try {
            res = num1 / num2;
        } catch (Exception e) {
            e.printStackTrace(); // 打出错误行
        }

        System.out.println("程序继续运行。。。");
        // num1 / num2 抛出异常 ArithmeticException 程序退出，下面的代码不再执行。程序崩溃
        // 若一段代码可能出现异常，则使用try-catch解决，保证程序的健壮性
        // 快捷键 选中 + command + option + t ，选择6
        // 快捷键 选中 + ctrl + alt + t， 选择6
        System.out.println(res);
    }
}
