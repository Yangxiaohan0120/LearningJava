package advanceJava.CodeBlock;

/**
 * @ author: yxh
 * @ created: 2022-02-26 : 9:43 PM
 */
public class CodeBlockIII {

    public static void main(String[] args) {
        new BBB();
    }
}

/// ============================
// 构造器的最前面其实隐含了super() 和调用普通代码块
// 静态相关的代码块，属性初始化等，在类加载的时候就已经执行完毕了 。
// class A{
//    public A(){
//        super();
//        System.out.println("ok");
//    }
// }


class AAA {

    public AAA() {
        System.out.println("AAA() 构造器被调用");
    }
}

class BBB extends AAA{

    {
        System.out.println("BBB 的普通代码块");
    }

    public BBB() {
        // super();
        System.out.println("BBB() 构造器被调用");
    }
}