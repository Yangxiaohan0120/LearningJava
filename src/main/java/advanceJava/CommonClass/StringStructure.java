package advanceJava.CommonClass;

/**
 * @author Chris Yang
 * created 2022-03-16 15:09
 **/
public class StringStructure {

    // 输入一个字符串，判断有多少大写字母，多少小写字母，多少数字
    public static void main(String[] args) {
        String s = "asfas24124sdwADASFASFasda3e124";
        int[] res = StringS(s);
        System.out.println(String.format("输入的字符串中有%s个大写字母，%s个小写字母，%s个数字",res[0],res[1],res[2]));
    }

    public static int[] StringS(String s){
        int[] res = new int[3];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] <= 'Z' && chars[i] >= 'A'){
                res[0]++;
            }
            if(chars[i] <= 'z' && chars[i] >= 'a'){
                res[1]++;
            }
            if(chars[i] <= '9' && chars[i] >= '0'){
                res[2]++;
            }
        }
        return res;
    }
}
