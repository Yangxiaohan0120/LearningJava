package 剑指Offer;

/**
 * @author Chris Yang
 * created 2022-08-05 10:40
 **/
public class StringToInt {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0)return 0;
        int i = 1, sign = 1;
        if(c[0] == '-')sign = -1;
        else if(c[0] != '+')i = 0;
        int res = 0, bny = Integer.MAX_VALUE/10;
        for(; i < c.length ; i ++){
            if(c[i] < '0' || c[i] > '9')break;
            if(res > bny || res == bny && c[i] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }else {
                res = res * 10 + (c[i] - '0');
            }
        }
        return res * sign;
    }

    public static void main(String[] args) {
        String r = "2147483648";
        int res = new StringToInt().strToInt(r);
        System.out.println(res);
    }
}
