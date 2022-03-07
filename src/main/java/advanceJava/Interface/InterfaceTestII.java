package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 9:45 PM
 */
public class InterfaceTestII {

    public static void main(String[] args) {

    }
}

interface A01{
    int x = 0; // ==> public static final int x = 0;
}

class B01{
    int x = 1;
}

class C01 extends B01 implements A01{
    public void pX(){
//        System.out.println(x); //编译时报错
        System.out.println(A01.x); // 明确指定x
        System.out.println(super.x); // 访问父类需要使用super.x
    }

    public static void main(String[] args) {
        new C01().pX();
    }
}