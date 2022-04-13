package advanceJava.Thread.Use;

/**
 * @author Chris Yang
 * created 2022-04-11 19:11
 **/
public class ThreadUse03 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new T1());
        Thread thread2 = new Thread(new T2());
        thread1.start();
        thread2.start();
    }
}

class T1 implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while (true) {
            //每隔1秒输出 “hello,world”,输出10次
            System.out.println("hello,world " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 60) {
                break;
            }
        }
    }
}

class T2 implements Runnable {

    int count = 0;

    @Override
    public void run() {
        //每隔1秒输出 “hi”,输出5次
        while (true) {
            System.out.println("hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 50) {
                break;
            }
        }
    }
}