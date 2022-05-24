package Multithreading;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Chris Yang
 * created 2022-05-20 10:01
 **/
public class CyclicBarrier_ {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier;
    }
}

class CyclicBarrierDemo{
    static class PreTask implements Runnable{

        private String task;
        private CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            try{
                for (int i = 1; i <= 4; i++) {
                    System.out.println(String.format("关卡%d的%s任务开始执行",i,task));
                    Random random = new Random();
                    Thread.sleep(random.nextInt(10));
                    System.out.println(String.format("关卡%d的%s任务执行完毕",i,task));
                    cyclicBarrier.await();
                }
            }catch (InterruptedException | BrokenBarrierException exception){
                exception.printStackTrace();
            }
            cyclicBarrier.reset();
        }

        public PreTask(String task,CyclicBarrier cyclicBarrier){
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,() ->{
            System.out.println("本关所有前置任务已完成，开始游戏");
        });

        new Thread(new PreTask("地图加载",cyclicBarrier)).start();
        new Thread(new PreTask("人物加载",cyclicBarrier)).start();
        new Thread(new PreTask("音乐加载",cyclicBarrier)).start();
    }
}
