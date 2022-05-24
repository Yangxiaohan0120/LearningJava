package Multithreading;

import java.util.HashSet;
import java.util.stream.Stream;

/**
 * @author Chris Yang
 * created 2022-05-20 17:13
 **/
public class Stream_ {
    public static void main(String[] args) {
        Stream stream;
        new Stream_().SingleStream();
        System.out.println("==============");
        new Stream_().MultiStream();


//        HashSet<String> set = new HashSet<>();
//        set.stream().parallel();
    }

    public void SingleStream(){
        Stream.of(1,2,3,4,5,6,7,8,9,10).reduce((a,b) -> {
            System.out.println(String.format("%s : %d + %d = %d",
                    Thread.currentThread().getName(),a,b,a+b));
            return a+b;
        }).ifPresent(System.out::println);
    }

    public void MultiStream(){
        Stream.of(1,2,3,4,5,6,7,8,9,10).parallel().reduce((a,b) -> {
            System.out.println(String.format("%s : %d + %d = %d",
                    Thread.currentThread().getName(),a,b,a+b));
            return a+b;
        }).ifPresent(System.out::println);
    }

}
