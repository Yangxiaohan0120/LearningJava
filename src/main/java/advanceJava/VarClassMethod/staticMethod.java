package advanceJava.VarClassMethod;

/**
 * @ author: yxh
 * @ created: 2022-02-25 : 7:43 PM
 */
public class staticMethod {

    public staticMethod() {

    }

    public static void main(String[] args) {
        stu b = new stu("mary");
        b.showFee();
    }

}

class stu {
    private String name;

    // 定义一个静态变量去累积学生的学费

    public static double fee = 0;

    public stu(String name) {
        this.name = name;
    }

    // 1. 使用静态static修饰的方法为静态方法
    // 2. 静态方法可以调用静态变量
    // 3. 类方法不可以使用关键字this，普通方法可以使用this
    // 4. 普通方法不可以使用类名调用，只能先生成一个实例，才可以调用。
    // 5. 普通方法可以访问静态成员，和非静态成员
    public static void payFee(double fee){
        stu.fee += fee;
    }

    public void showFee(){
        System.out.println("总学费： "+ stu.fee);
    }
}