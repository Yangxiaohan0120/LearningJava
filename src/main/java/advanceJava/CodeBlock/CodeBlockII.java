package advanceJava.CodeBlock;

/**
 * @ author: yxh
 * @ created: 2022-02-26 : 9:28 PM
 */
public class CodeBlockII {

    // 难点：创建一个对象时，在一个类中的调用顺序：
    // 1. 调用静态代码块和静态属性初始化
    // 2. 调用普通代码块和普通属性的初始化
    // 3. 调用构造方法

    public static void main(String[] args) {
        A a = new A();
    }
}

class A {

    {
        System.out.println("A 的普通代码块");
    }

    private int n2 = getN2();

    static {
        System.out.println("A 的静态代码块");
    }

    private static int n1 = getN1();

    public static int getN1(){
        System.out.println("getN1被调用");
        return 100;
    }

    public int getN2(){
        System.out.println("getN2。。。");
        return 1000;
    }

    public A(){
        System.out.println("A 构造器");
    }

}