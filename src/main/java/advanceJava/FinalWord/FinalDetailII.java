package advanceJava.FinalWord;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 2:51 PM
 */

// 细节：
// 如果一个类已经是final，没有必要再修饰其中的方法为final
// final不能修饰构造方法（构造器）
// final和static 搭配使用，不会使类加载，效率更高，底层编译器做了优化处理
// 包装类（Integer，Double，Float，Boolean），String 都是final类

public class FinalDetailII {
    public static void main(String[] args) {
        System.out.println(BBB.num);
        System.out.println(BBB.num1);
        // 包装类和String都是final类，不能被继承
        String a;
        Boolean n;
    }
}


final class AAA {
    //    public final void cry() {
    public void cry() {
    }
}


class BBB{
    // final + static 类不加载，只使用此变量
    public final static int num = 100000;
    // 只使用static，还是会加载静态代码块
    public static int num1 = 100;
    static {
        System.out.println("BBB 静态代码块被执行");
    }
}