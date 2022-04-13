package advanceJava.Thread.Use;

/**
 * @author Chris Yang
 * created 2022-04-11 19:06
 **/


// 使用Thread本身就继承了Runnable接口
// 使用Runnable更加适合多个线程使用同一个资源的情况，避免了单继承的限制。
public class ThreadUse02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.start(); 这里不能调用start
        //创建了Thread对象，把 dog对象(实现Runnable),放入Thread
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();//实现了 Runnable
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal{

}

class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("老虎哇哦污");
    }
}

//线程代理类 , 模拟了一个极简的Thread类
class ThreadProxy implements Runnable {//你可以把Proxy类当做 ThreadProxy

    private Runnable target = null;//属性，类型是 Runnable

    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型Tiger）
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//这个方法时真正实现多线程方法
    }

    public void start0() {
        run();
    }
}


class Dog implements Runnable{
    int count = 0;

    @Override
    public void run() {
        while(true){
            System.out.println("小狗汪汪叫" + (++count) + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(count == 10){
                break;
            }
        }
    }
}