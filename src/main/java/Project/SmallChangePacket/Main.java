package Project.SmallChangePacket;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-03-07 14:55
 **/
public class Main {

    private String MainMenu = "============Menu===========\n" +
            "           1. 明细          \n" +
            "           2. 收入          \n" +
            "           3. 消费          \n" +
            "           4. 清除          \n" +
            "           5. 退出          \n";

    public int TotalMoney = 0;
    Scanner scanner;
    File detail = new File("detail.txt");
    boolean loop = true;
    String buffered;

    public void start() throws IOException {
        scanner = new Scanner(System.in);
        if (detail.exists()) {
            detail.delete();
            detail.createNewFile();
        }
        do {
            System.out.println(MainMenu);
            int key = Integer.parseInt(scanner.next());
            getOptions(key);
        } while (loop);
    }

    public void getOptions(int key) throws IOException {
        if (key == 1) {
            Functions.getPrint();
            System.out.println("结余" + TotalMoney);
        } else if (key == 2) {
            System.out.println("请输入金额：");
            int money = Integer.parseInt(scanner.next());
            TotalMoney = Functions.getIn(money, TotalMoney, detail);
        } else if (key == 3) {
            System.out.println("请输入金额：");
            int money = Integer.parseInt(scanner.next());
            TotalMoney = Functions.getOut(money, TotalMoney, detail);
        } else if (key == 4) {
            Functions.getClear(detail);
            TotalMoney = 0;
        } else if (key == 5) {
            loop = Functions.quit(scanner);
        } else {
            System.out.println("Sorry, we don't have " + key + " option!");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().start();
    }
}
