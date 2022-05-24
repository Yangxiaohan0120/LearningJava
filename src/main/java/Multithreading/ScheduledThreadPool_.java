package Multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Chris Yang
 * created 2022-05-20 17:24
 **/
public class ScheduledThreadPool_ {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Timer timer;
    }
}

class SendMessagesTimelapse{

    // public ScheduledThreadPoolExecutor(int corePoolSize,
    //                                   ThreadFactory threadFactory) {
    //    super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
    //          new DelayedWorkQueue(), threadFactory);
    // }
    public static final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Executors.defaultThreadFactory());

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean hasMessage(){
        return true;
    }

    public static void main(String[] args) {
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                if(hasMessage()){
                    System.out.println(dateFormat.format(new Date()));
                    System.out.println("发送消息");
                }
            }
        },1,1, TimeUnit.SECONDS);
    }


}
