package weekContest.Double128;

public class Test01 {

    public int scoreOfString(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length - 1; i++) {
            int num = c[i] - c[i+1];
            if(num >= 0){
                res += num;
            }else{
                res -= num;
            }
        }
        return res;
    }

    public void test(){
        String s = "hello";
        int res = scoreOfString(s);
        System.out.println(res);
    }

    public static void main(String[] args) {
        new Test01().test();
    }
}
