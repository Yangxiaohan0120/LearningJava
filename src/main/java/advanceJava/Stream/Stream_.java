package advanceJava.Stream;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Chris Yang
 * created 2022-03-29 21:52
 **/
public class Stream_ {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] a = {1,2,3};
        IntStream ab = Arrays.stream(a).filter(i -> i >2);

        String[] array = {"1","1","2","2","3","4","4","5","5","5","6"};
        List newList = (List) Arrays.stream(array).distinct().collect(Collectors.toList());
        newList.stream().forEach(f -> {
            System.out.println(f);
        });


        int[] arr = {1,1,2,2,3};
        int[] arr1 = Arrays.stream(arr).distinct().toArray();
        Arrays.stream(arr1).forEach(f ->{
            System.out.println(f);
        });
    }
}
