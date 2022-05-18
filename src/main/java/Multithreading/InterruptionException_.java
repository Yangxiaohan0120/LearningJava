package Multithreading;

/**
 * @author Chris Yang
 * created 2022-05-18 13:36
 **/
public class InterruptionException_ {
    public static void main(String[] args) {

        Thread th = Thread.currentThread();
        while(true){
            if(th.isInterrupted()){
                break;
            }
            // 省略代码
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                // 如果其他线程导致了这个线程的中断，会触发异常，
                // 同时也吧中断标志位清除了
                // isInterrupted 返回 false ，就不会走向break
                e.printStackTrace();
                // 应该重新设置中断标志
                th.interrupt();
            }
        }

    }
}
