package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 9:11 PM
 */
public class InterfaceTestI {
    public static void main(String[] args) {

    }
}

interface A{
    int a = 23;
}

class B implements A{

    // 在接口中的 int a = 23; <==> public static final int a = 23;
    // 所有的输出都正确
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a); //23
        System.out.println(A.a); //23
        System.out.println(B.a); //23
    }
}