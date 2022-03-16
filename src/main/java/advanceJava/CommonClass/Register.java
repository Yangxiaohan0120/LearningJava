package advanceJava.CommonClass;

import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-03-16 14:38
 **/
public class Register {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = scanner.next();
        System.out.println("Please enter your password");
        String password = scanner.next();
        System.out.println("Please enter your email");
        String email = scanner.next();
        RegisterCorrection(name, password, email);
        System.out.println("Register successful");
    }

    public static void RegisterCorrection(String name, String password, String email) {
        if (name.length() < 2 && name.length() > 4) {
            throw new IllegalArgumentException("name length is not required");
        }

        if (password.length() != 6 || !isDigital(password)) {
            throw new IllegalArgumentException("password length is wrong");
        }

        int a = email.indexOf('@');
        int b = email.indexOf('.');
        if (a < 0 || b < 0 || b < a) {
            throw new IllegalArgumentException("email format is not required");
        }
    }

    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9')
                return false;
        }
        return true;
    }
}
