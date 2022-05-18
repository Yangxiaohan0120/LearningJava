package Multithreading;

import javax.management.monitor.Monitor;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author Chris Yang
 * created 2022-05-17 22:04
 **/

// 信号量的使用
public class Semaphore_ {
    // 模拟框架
    int count;
    Queue queue;

    Semaphore_(int c) {
        this.count = c;
    }

    void down() {
        this.count--;
        if (this.count < 0) {
            // 当前线程插入等待队列
            // 阻塞当前线程
        }
    }

    void up() {
        this.count++;
        if (this.count >= 0) {
            // 移除等待队列中的某个线程
            // 唤醒线程
        }
    }

    // 实际使用
    static int counts;
    static final Semaphore semaphore = new Semaphore(1);

    static void addOne() throws InterruptedException {
        // 获取信号量
        semaphore.acquire();
        try {
            counts += 1;
        }finally {
            // 归还信号量
            semaphore.release();
        }
    }

    public static void main(String[] args) {

    }
}

// 使用信号量实现限流器
class ObjPool<T,R>{
    // 对象池
    final List<T> pool;
    // 信号量
    final Semaphore sem;

    public ObjPool(int size,T t){
        this.pool = new Vector<T>(){};
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    R exec(Function<T,R> func) throws Exception {
        T t = null;
        sem.acquire(); // 计数器减一
        try{
            t = pool.remove(0);
            return func.apply(t);
        }finally {
            pool.add(t);
            sem.release(); // 执行完毕，计数器加一
        }
    }

    public static void main(String[] args) throws Exception {
        String a = "cheng";
        ObjPool<Long,String> pool = new ObjPool<>(10,2L);
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}
