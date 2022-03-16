package advanceJava.CommonClass;

import org.checkerframework.checker.units.qual.C;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-03-15 21:08
 **/
public class DateClass {
    public static void main(String[] args) {
        // Date 类
        Date date = new Date();
        date.getTime();
        System.out.println(date);
        System.out.println(date.getTime());

        // 格式转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        System.out.println(simpleDateFormat.format(date));

        // Calendar类
        // Calendar 是抽象类，需要通过getInstance来获取实例
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // LocalDate
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒");
        System.out.println(dateTimeFormatter.format(localDateTime));

        LocalDate localDate = LocalDate.now(); //获取日期
        LocalTime localTime = LocalTime.now(); //获取时间

        // Instant时间戳
        Instant instant = Instant.now();
        System.out.println(instant);
        // 转换为date
        Date date1 = Date.from(instant);
        System.out.println(date1);
        // date转换为时间戳
        Instant instant1 = date1.toInstant();
        System.out.println(instant1);


    }
}
