package advanceJava.Stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Chris Yang
 * created 2022-03-29 21:52
 **/
public class Stream_ {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        IntStream ab = Arrays.stream(a).filter(i -> i >2);

    }
}
