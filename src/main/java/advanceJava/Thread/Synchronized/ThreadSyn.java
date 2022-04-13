package advanceJava.Thread.Synchronized;

/**
 * @author Chris Yang
 * created 2022-04-11 20:11
 **/

// Synchronized 的使用

// 互斥锁: 每个对象都可以称作为一个互斥锁的标记,当某个对象被synchronized标记后，表明这只能同时被一个线程访问。

// 同步方法如果没有被static 修饰，默认为this
// 如果被static修饰，则认为是当前类.class

public class ThreadSyn {

    Object object = new Object();


    // 同步代码块
    public void m1(){
        synchronized (this.object){

        }
    }

    // 同步方法
    public synchronized void m2(){

    }

    public static void m3(){
        synchronized (ThreadSyn.class){

        }
    }

    public static void main(String[] args) {

    }
}

