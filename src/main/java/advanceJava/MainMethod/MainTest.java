package advanceJava.MainMethod;

/**
 * @ author: yxh
 * @ created: 2022-02-25 : 8:43 PM
 */
public class MainTest {

    private static String name = "name";
    private int n1 = 10000;

    public static void hi(){
        System.out.println("hi");
    }

    public void cry(){
        System.out.println("cry");
    }

    public static void main(String[] args) {
        // 可以直接使用name
        //1. 静态方法main 可以访问本类的静态成员
        System.out.println("name = "+ name);
        hi();
        //2. 静态方法main 不可以访问本类的非静态成员
        //System.out.println("n1 = "+n1); // n1 非静态
        //3. 静态方法main 不可以调用本类的非静态方法
        //cry()// cry 非静态方法
        //4. 静态方法main 如果想要调用本垒的非静态方法，需要先生成一个对象（实例化）
        new MainTest().cry();
    }
}