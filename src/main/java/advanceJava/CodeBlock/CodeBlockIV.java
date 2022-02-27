package advanceJava.CodeBlock;

/**
 * @ author: yxh
 * @ created: 2022-02-26 : 10:50 PM
 */
public class CodeBlockIV {
    public static void main(String[] args) {
        // 类的加载
        // 加载 A1，B1
        // 创建对象
        new B1();
    }

}

//代码块在继承中的调用顺序：
// 1. 父类的静态代码块和静态属性（优先级一样，按照定义顺序执行）
// 2. 子类的静态代码块和静态属性（优先级一样，按照定义顺序执行）
// 3. 父类的普通代码块和普通属性初始化（优先级一样，按照定义顺序执行）
// 4. 父类的构造方法
// 5. 子类的普通代码块和普通属性初始化（优先级一样，按照定义顺序执行）
// 6. 子类的构造方法

// 静态代码块只能直接调用静态成员（静态属性和静态方法）
// 普通代码块可以调用任意成员

class A1 {

    public static int n1 = getV1();//(2)

    static {
        System.out.println("A1 static"); //(3)
    }

    public int n2 = getV2();//(6)

    {
        System.out.println("A1 putong");//(7)
    }

    public static int getV1() { //(2)
        System.out.println("getV1 ... ");
        return 100;
    }

    public int getV2() {
        System.out.println("getV2 ...");
        return 200;
    }

    public A1() {
        // super() //(8) 父类为object所以不往回走
        System.out.println("A1 constructor");
    }
}

class B1 extends A1 {

    public static int n1 = getV3();//(4)
    static {
        System.out.println("B1 static");//(5)
    }
    public int n2 = getV4(); //(9)
    {
        System.out.println("B1 putong"); //(10)
    }

    public static int getV3() {
        System.out.println("getV3 ... "); //(4)
        return 100;
    }

    public static int getV4() {
        System.out.println("getV4 ... "); //(9)
        return 200;
    }

    public B1() {
        // super()(1)
        System.out.println("B1 constructor"); //(10)
    }
}