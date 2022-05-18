package Multithreading;

import javax.xml.ws.Response;
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
