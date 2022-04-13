package advanceJava.Thread.Use;

/**
 * @author Chris Yang
 * created 2022-04-11 19:15
 **/
public class SellTicket {
    public static void main(String[] args) {
//        System.out.println("使用继承方法进行售票-----");
//
//        SellWindow01 sellWindow01_1 = new SellWindow01();
//        SellWindow01 sellWindow01_2 = new SellWindow01();
//        SellWindow01 sellWindow01_3 = new SellWindow01();
//
//        sellWindow01_1.start();
//        sellWindow01_2.start();
//        sellWindow01_3.start();

//        System.out.println("使用接口的方法进行售票-----");
//        SellWindow02 sellWindow02 = new SellWindow02();
//
//        new Thread(sellWindow02).start();
//        new Thread(sellWindow02).start();
//        new Thread(sellWindow02).start();

        SellWindow03 sellWindow03 = new SellWindow03();
        new Thread(sellWindow03).start();
        new Thread(sellWindow03).start();
        new Thread(sellWindow03).start();

    }
}

class SellWindow03 implements Runnable{
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object();

    //同步方法（静态的）的锁为当前类本身
    //老韩解读
    //1. public synchronized static void m1() {} 锁是加在 SellTicket03.class
    //2. 如果在静态方法中，实现一个同步代码块.
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1(){

    }

    public static void m2(){
        synchronized (SellWindow03.class){
            System.out.println("m2");
        }
    }

    //老韩说明
    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象
    public /*synchronized*/ void sell(){
        synchronized (/*this.*/ object){
            if(ticketNum <= 0){
                System.out.println("售票结束");
                loop = false;
                return;
            }

            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run(){
        while(loop){
            sell();
        }
    }
}

class SellWindow01 extends Thread{

    private static int ticketNum = 100;

    @Override
    public void run(){
        while (true){
            if(ticketNum <= 0){
                System.out.println("票已售完");
                break;
            }

            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，还剩"+(--ticketNum));
        }
    }
}


class SellWindow02 implements Runnable{

    private static int ticketNum = 100;

    @Override
    public void run(){
        while (true){
            if(ticketNum <= 0){
                System.out.println("票已售完");
                break;
            }

            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，还剩"+(--ticketNum));
        }
    }
}