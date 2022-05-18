package Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * @author Chris Yang
 * created 2022-05-18 10:14
 **/
public class Monitor_ {
    public static void main(String[] args) {
        // 使用Lock 和 Condition 来实现管程
    }
}

// await 等价于 wait
// signal 等价于 notify


class BlockQueue<T> {

    private int n = 10;
    final Lock lock = new ReentrantLock();

    // 条件变量：队列不满，队列不空
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    //入队
    void enq(T x) {
        lock.lock();
        try {
            while (n < 5) { // 队列已满，notFull 等待
                notFull.await();
            }
            // 入队操作
            // 入队后，可通知出队
            notEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // 出队
    void deq() {
        lock.lock();
        try {
            while (n < 5) { // 队列已空，notEmpty 等待
                notEmpty.await();
            }
            // 出队操作
            // 出队后，可通知入队
            notFull.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}

