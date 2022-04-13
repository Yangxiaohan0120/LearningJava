package advanceJava.Thread.State;

/**
 * @author Chris Yang
 * created 2022-04-11 20:04
 **/

// Thread 的状态：NEW,
//        RUNNABLE,
//        BLOCKED,
//        WAITING,
//        TIMED_WAITING,
//        TERMINATED;

// new Thread ====>  NEW
// start()    ====>  RUNNABLE ( Ready --> Running )
// sleep() / wait() / join() / LockSupport.parkNanos() / LockSupport.parkUntil()  ====>  TIMED_WAITING
// wait() / join() / LockSupport.park()  ====> WAITING  ====> notify() / notifyAll() / LockSupport.unpark() ====> Runnable
// 等待同步代码块的锁进入 Blocked

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " 状态 " + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
        }

        System.out.println(t.getName() + " 状态 " + t.getState());

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
