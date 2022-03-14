package Multithreading;

import DataStructureAndAlgorithm.homework.Student;
import advanceJava.Interface.Phone;

import java.util.concurrent.FutureTask;

/**
 * @author Chris Yang
 * @create 2022-03-08 12:49
 **/
public class Priority01 {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            System.out.println("线程组的名字"+Thread.currentThread().getThreadGroup().getName());
            System.out.println("线程的名字"+Thread.currentThread().getName());
        });

        thread.start();
        System.out.println("执行main方法的线程名：" + Thread.currentThread().getName());

        Thread a = new Thread();
        System.out.println("默认优先级"+a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("设定优先级"+b.getPriority());

    }
}
