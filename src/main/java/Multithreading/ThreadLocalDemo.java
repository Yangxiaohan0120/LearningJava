package Multithreading;

/**
 * @author Chris Yang
 * created 2022-03-08 16:32
 **/
public class ThreadLocalDemo {
    static class A implements Runnable{

        private ThreadLocal<String> threadLocal;

        public A(ThreadLocal<String> threadLocal){
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Thread A : " + threadLocal.get());
        }
    }

    static class B implements Runnable{
        private ThreadLocal<String> threadLocal;

        public B(ThreadLocal<String> threadLocal){
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Thread B : " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        new Thread(new A(threadLocal)).start();
        new Thread(new B(threadLocal)).start();
    }
}
