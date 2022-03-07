package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 8:50 PM
 */
public interface InterfaceII {
    public int n1 = 10;// 属性

    public void hi(); // interface 中默认都是抽象方法

    default public void ok(){ // interface 中可以实现默认方法
        System.out.println("ok .. ");
    }

    public static void say(){
        System.out.println("saying");
    }
}