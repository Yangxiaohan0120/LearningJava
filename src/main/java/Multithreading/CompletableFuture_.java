package Multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Chris Yang
 * created 2022-05-22 19:05
 **/
public class CompletableFuture_ {
    public static void main(String[] args) {

        CompletableFuture completableFuture;


        // 描述串行关系：
        // thenAccept、thenApply、thenRun、thenCompose

        // 描述 AND 汇聚关系：
        // thenCombine、thenAcceptBoth、thenRunBoth

        // 描述 OR 汇聚关系：
        // applyToEither、acceptEither、runAfterEither

    }
}

// 使用 CompletableFuture 实现异步编程

class TeaMaking {
    // T1 负责洗水壶，烧开水
    // T2 负责洗茶杯，拿茶叶
    // T3 等待线程结束后，加茶叶，泡茶

    static CompletableFuture<Void> T1 = CompletableFuture.runAsync(() -> {
        try {
            System.out.println("洗水壶。。。。。。");
            sleep(20, SECONDS);

            System.out.println("烧开水。。。。。。");
            sleep(45, SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });

    static CompletableFuture<String> T2 = CompletableFuture.supplyAsync(() -> {
        try {
            System.out.println("洗茶杯。。。。。。");
            sleep(20, SECONDS);

            System.out.println("拿茶叶。。。。。。");
            sleep(1, SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "普洱";
    });


    // thenCombine 互相之间有依赖关系的必须等待上一步操作结束
    static CompletableFuture<String> T3 = T1.thenCombine(T2, (__, tf) -> {
        System.out.println("拿到茶叶");
        System.out.println("泡茶");
        return "上茶: " + tf;
    });

    static void sleep(int a, TimeUnit u){
        try{
            u.sleep(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(T3.join());
    }
}
