package Project.SmallChangePacket;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Chris Yang
 * created 2022-03-07 15:01
 **/
public class Functions {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static Date date;
    static StringBuilder sb = new StringBuilder();
    static String record;

    public static void detail(boolean in, int money, File detail) {
        if (in) {
            record = "收入";
        } else {
            record = "支出";
        }
        date = new Date();
        sb.setLength(0);
        sb.append(sdf.format(date) + record + money);
        try {
            if (!detail.exists()) {
                detail.createNewFile();
            }
            FileWriter fw = new FileWriter(detail, true);
            fw.write(sb.toString() + "\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getIn(int money, int totalMoney, File detail) {
        if (money < 0) {
            System.out.println("数据输入有误，收入应该 > 0");
        } else {
            detail(true, money, detail);
            totalMoney = totalMoney + money;
            System.out.println("收入" + money);
        }
        return totalMoney;
    }

    public static int getOut(int money, int totalMoney, File detail) {
        if (money < 0) {
            System.out.println("数据输入有误，花费应该 > 0");
        } else if (totalMoney - money < 0) {
            System.out.println("余额不足");
        } else {
            detail(false, money, detail);
            totalMoney = totalMoney - money;
            System.out.println("消费" + money);
        }
        return totalMoney;
    }

    public static void getClear(File detail) throws IOException {
        detail.delete();
        detail.createNewFile();
    }

    public static void getPrint() {
        try {
            String temp;
            File directory = new File(".");
            if (!new File(directory.getAbsolutePath() + "/detail.txt").exists()) {
                System.out.println("No record");
            } else {
                BufferedReader br = new BufferedReader(new FileReader(directory.getAbsolutePath() + "/detail.txt"), 65536);
                if ((temp = br.readLine()) == null) {
                    System.out.println("No record");
                } else {
                    System.out.println(temp);
                }
                while ((temp = br.readLine()) != null) {
                    System.out.println(temp);
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean quit(Scanner scanner) {
        String answer = null;
        do {
            System.out.println("你确定要退出吗？y/n");
             answer = scanner.next();
        }
        while (!answer.equals("y") && !answer.equals("n"));

        if (answer.equals("y")) {
            System.out.println("退出了零钱通系统！");
            scanner.close();
            return false;
        } else {
            return true;
        }
    }

}
