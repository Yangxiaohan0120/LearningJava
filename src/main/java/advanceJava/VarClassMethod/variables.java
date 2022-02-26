package advanceJava.VarClassMethod;


/**
 * @ author: yxh
 * @ created: 2022-02-22 : 10:47 AM
 */

public class variables {

    private String name;
    // 类变量也称作为静态变量,应该使用static进行修饰，和private或者public 无关
    // 可以被所有的类共享
    public static int countSum = 0;

    public variables(String name) {
        this.name = name;
    }

    public void join(){
        countSum ++;
    }

    public static void main(String[] args) {
        // 类变量可以直接使用类名来访问
        System.out.println(variables.countSum);
        new variables("Child1").join();
        System.out.println(variables.countSum);
        new variables("Child2").join();
        System.out.println(variables.countSum);
        new variables("Child3").join();
        System.out.println(variables.countSum);
    }

}