package Multithreading;

import javax.xml.ws.Response;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chris Yang
 * created 2022-05-18 14:04
 **/
public class LockCondition_ {
    public static void main(String[] args) {
        Thread thread;
        Runnable runnable;
        Callable callable;
    }
}

class Lock_ {
    public final Lock lock = new ReentrantLock();

    int value;

    public int get(){
        lock.lock();
        try{
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void addOne(){
        lock.lock();
        try {
            value = 1 + get();
        }finally {
            lock.unlock();
        }
    }
}

class Condition_{

    Response response = null;
    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();

    Object get(int timeout) throws InterruptedException {
        long start = System.nanoTime();
        lock.lock();
        try{
            while(!isDone()){
                done.await();
                long cur = System.nanoTime();
                if(isDone() || cur-start > timeout){
                    break;
                }
            }
        }finally {
            lock.unlock();
        }
        return response;
    }

    boolean isDone(){
        return response != null;
    }

    private void doReceiced(Response res){
        lock.lock();
        try{
            response = res;
            if(done != null){
                done.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}

// 防止while(true)条件进入活锁

class Account{

    private int balance;

    private final Lock lock = new ReentrantLock();

    public void transfer(Account account,int count) throws InterruptedException {
        while(true){
            if(this.lock.tryLock()){
                try {
                    if(account.lock.tryLock()){
                        try{
                            this.balance += count;
                            account.balance -= count;
                            break; // 完成任务后强制退出
                        }finally {
                            account.lock.unlock();
                        }
                    }
                }finally {
                    lock.unlock();
                }
            }
            Thread.sleep(new Random().nextInt(100)); // 随即睡眠一定时间，错开高峰期
        }
    }
}
