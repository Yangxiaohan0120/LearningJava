package LeetCode;

/**
 * @author Chris Yang
 * created 2022-03-31 19:47
 **/
public class FindSmallestLetterGreaterThanTargetEasyAdd {
    public static char nextGreatestLetter(char[] letters, char target) {
        int Min = Integer.MAX_VALUE;
        char c = 0;
        System.out.println(letters.length);
        for (int i = 0; i < letters.length; i++) {
            if( letters[i] - target > 0  && letters[i] - target < Min){
                Min = letters[i] - target;
                c = letters[i];
            }
        }
        if(c == 0){
            return letters[0];
        }else {
            return c;
        }
    }

    public static void main(String[] args) {
        char arr[] = {'c','f','j'};
        char target = 'j';
        System.out.println(nextGreatestLetter(arr,target));
    }
}

