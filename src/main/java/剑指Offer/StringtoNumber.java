package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-07-26 21:51
 **/
public class StringtoNumber {
    public boolean isNumber(String s) {
        Map[] states = new Map[]{
                new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
                new HashMap(){{put('d',2);put('.',4);}},
                new HashMap(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
                new HashMap(){{put('d',3);put('e',5);put(' ',8);}},
                new HashMap(){{put('d',3);}},
                new HashMap(){{put('s',6);put('d',7);}},
                new HashMap(){{put('d',7);}},
                new HashMap(){{put('d',7);put(' ',8);}},
                new HashMap(){{put(' ',8);}}

        };
        char state = ' ';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                c = 'd';
            }else if(c == '+' || c == '-'){
                c = 's';
            }else if(c == 'e' || c == 'E'){
                c = 'e';
            }else if(c == '.'){
                c = '.';
            }else if(c == ' '){
                c = ' ';
            }else return false;
            if(states[res].get(c) != null){
                res = (int) states[res].get(c);
            }else return false;
        }
        if(res == 2 || res == 3 || res == 7 || res == 8){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] correction = {"+100", "5e2", "-123", "3.1416", "-1E-16", "0123"};
//        String[] wrong = {"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
//        for (int i = 0; i < correction.length; i++) {
//            System.out.println(new StringtoNumber().isNumber(correction[i]));
//        }
//        System.out.println("=======================");
//        for (int i = 0; i < wrong.length; i++) {
//            System.out.println(new StringtoNumber().isNumber(wrong[i]));
//        }

        System.out.println(new StringtoNumber().isNumber("1.2.3"));
    }
}
