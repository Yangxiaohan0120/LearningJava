package advanceJava.FinalWord;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 2:40 PM
 */

// 1）final修饰的属性一般叫做常量，使用XX_YY_ZZZ 来命名
// 2）在定义时，一定要赋值，且之后不可以再修改；赋值的位置：1）定义时 2）构造器中 3）代码块中
// 3）如果final修饰的属性是静态的，则初始化的位置只能是 1）定义时 2）静态代码块中 ； 不可以在构造器中赋值
// 4）final类不能继承，但是可以实例化对象
// 5）如果类不是final类，但是含有final方法，则方法不可以被重写，但是类可以被继承


public class FinalDetailI {
    public static void main(String[] args) {
        new CC();
        new EE().cal();
    }

}

class AA {

    // 定义时赋值
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE1;
    public final double TAX_RATE2;

    // 代码块中赋值
    {
        TAX_RATE2 = 0.05;
    }

    // 构造器中赋值
    public AA() {
        TAX_RATE1 = 0.02;
    }
}

class BB {
    // 定义时赋值
    public final static double TAX_RATE = 0.08;
    //    public final static double TAX_RATE1; // 构造器中不可赋值
    public final static double TAX_RATE2;

    // 代码块中赋值
    static { // 静态属性，只能在静态代码块中进行赋值
        TAX_RATE2 = 0.05;
    }

    // 构造器中赋值
    public BB() {
//        TAX_RATE1 = 0.02;
    }
}

final class CC {
    // main 中 new CC();
}

class DD{
    public final void cal(){
        System.out.println("cal()");
    }
}

class EE extends DD{
    // new EE().cal;

    // 不可重写，但可以被继承
//    @Override
//    public void cal(){
//
//    }
}