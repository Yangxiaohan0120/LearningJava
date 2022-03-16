package advanceJava.CommonClass;

import java.util.Locale;

/**
 * @author Chris Yang
 * created 2022-03-16 15:02
 **/
public class NameAbbreviation {

    // 打印名字缩写：Han shun Ping ---> Ping,S Han
    public static void main(String[] args) {
        String name = "Han shun Ping";
        System.out.println(nameAbbr(name));
    }

    public static String nameAbbr(String name){
        String[] names = name.split(" ");
        if(names.length < 3){
            throw new IllegalArgumentException("Name format is uncorrect");
        }

        String res = String.format("%s,%s %c",names[2],names[0],names[1].toUpperCase().charAt(0));
        return res;
//        StringBuilder sb = new StringBuilder();
//        sb.append(names[2]+","+names[0]+" "+String.valueOf(names[1].charAt(0)).toUpperCase());
//        return sb.toString();

    }
}
