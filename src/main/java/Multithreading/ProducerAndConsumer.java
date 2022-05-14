package Multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Chris Yang
 * created 2022-05-07 21:11
 **/
public class ProducerAndConsumer {
    int queueSize = 5;
    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        Producer producer = producerAndConsumer.new Producer();
        Consumer consumer = producerAndConsumer.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {


        @Override
        public void run() {
            consume();
        }

        public void consume() {
            while (true) {
                try {
                    blockingQueue.take();
                    System.out.println("Consumer 拿走一个线程, 还剩下 " + blockingQueue.size() + " 个线程");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        public void produce() {
            while(true){
                try{
                    blockingQueue.put(1);
                    System.out.println("Producer 生产一个线程, 还剩下 " + blockingQueue.size() + " 个线程");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

}