package Multithreading;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @author Chris Yang
 * created 2022-05-20 10:47
 **/
public class Phaser_ {
    public static void main(String[] args) {
        Phaser phaser;
    }
}

class PhaserDemo {
    static class PreTask implements Runnable {

        private String task;
        private Phaser phaser;

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 4; i++) {
                    if (i >= 2 && task.equals("加载新手教程")) {
                        continue;
                    }
                    Random random = new Random();
                    Thread.sleep(random.nextInt(10));
                    System.out.println(String.format("关卡%d需要加载%d个模块，当前模块[%s]", i, phaser.getRegisteredParties(), task));
                    if (i == 1 && task.equals("加载新手教程")) {
                        System.out.println("下次关卡移除新手模块");
                        phaser.arriveAndDeregister();
                    } else {
                        phaser.arriveAndAwaitAdvance();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public PreTask(String task, Phaser phaser) {
            this.phaser = phaser;
            this.task = task;
        }
    }

    public static void main(String[] args) {
        Phaser phaser = new Phaser(4) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println(String.format("第%d次关卡准备完成", phase + 1));
                return registeredParties == 3 || registeredParties == 0;
            }
        };

        new Thread(new PreTask("加载地图模型",phaser)).start();
        new Thread(new PreTask("加载人物模型",phaser)).start();
        new Thread(new PreTask("加载背景音乐",phaser)).start();
        new Thread(new PreTask("加载新手教程",phaser)).start();
    }
}