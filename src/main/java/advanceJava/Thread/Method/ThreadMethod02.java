package advanceJava.Thread.Method;

/**
 * @author Chris Yang
 * created 2022-04-11 19:49
 **/

// yield 线程的礼让: 让出cpu，让其他的线程进行，但不确定礼让的时间，所以也有可能礼让不成功
// join 线程的插队，一旦插入成功，必须先完成插入线程的任务

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for(int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(小弟) 吃了 " + i  + " 包子");
            if(i == 5) {
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                //join, 线程插队
                t2.join();// 这里相当于让t2 线程先执行完毕
//                Thread.yield();//礼让，不一定成功..
                System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
            }

        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了 " + i +  " 包子");
        }
    }
}
