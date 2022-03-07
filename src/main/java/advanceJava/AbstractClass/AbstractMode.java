package advanceJava.AbstractClass;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 4:05 PM
 */

// 抽象类最佳实践：模板设计模式

// 1) 有多个类，完成不同的任务
// 2）要求统计各自完成任务的时间


// 将多种相似类型的类进行父类合并，使用抽象方法进行概括


public class AbstractMode {

    public static void main(String[] args) {
        AA a = new AA();
        a.calculate();

        BB b = new BB();
        b.calculate();
    }
}

abstract class template{

    public abstract void job();

    public void calculate(){
        long startTime = System.currentTimeMillis(); // 返回1970年至今的毫秒数
        job(); // 动态绑定机制
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间 " + (endTime - startTime) + "ms.");
    }
}

class AA extends template{
    // job 计算任务
    // 1+...+1000
    @Override
    public void job() {
        System.out.println("AA 1+...10000000");
        int num = 0;
        for (int i = 1; i <= 1000000; i++) {
            num += i;
        }
    }
}


class BB extends template {
    // job 计算任务
    // 1*...*1000
    @Override
    public void job() {
        System.out.println("BB 1*...10000000");
        int num = 0;
        for (int i = 1; i <= 10000000; i++) {
            num *= i;
        }
    }
}


