package advanceJava.Collections.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author Chris Yang
 * created 2022-03-29 15:03
 **/
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet<AEmployee> set = new HashSet<>();
        set.add(new AEmployee("Jack", 3500, new MyDate(1998, 2, 28)));
        set.add(new AEmployee("Rose", 3500, new MyDate(1989, 1, 21)));
        set.add(new AEmployee("Jack", 4600, new MyDate(1998, 6, 8)));
        set.add(new AEmployee("Jack", 3500, new MyDate(1998, 5, 2)));
        set.add(new AEmployee("Jack", 4600, new MyDate(1998, 2, 28)));
        System.out.println("set=" + set);
    }
}

class AEmployee {
    private String name;
    private int sal;
    private MyDate birthday;

    public AEmployee(String name, int sal, MyDate date) {
        this.name = name;
        this.sal = sal;
        this.birthday = date;
    }


    // 确保hash值的唯一
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    // 确保值的唯一
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AEmployee employee = (AEmployee) o;
        return Objects.equals(birthday, employee.birthday) && Objects.equals(name, employee.name);
    }

    @Override
    public String toString() {
        return "AEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        if (year > 9999 || year < 1) {
            throw new IllegalArgumentException("year is out of range");
        } else {
            this.year = year;
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month is out of range");
        } else {
            this.month = month;
        }
        int td = days[month - 1];
        if (year % 4 == 0 && year % 400 != 0 && month == 2) {
            td += 1;
        }
        if (day > td) {
            throw new IllegalArgumentException("day is out of range");
        } else {
            this.day = day;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;

        if (year != myDate.year) return false;
        if (month != myDate.month) return false;
        if (day != myDate.day) return false;
        return Arrays.equals(days, myDate.days);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        result = 31 * result + Arrays.hashCode(days);
        return result;
    }

    public boolean equals(MyDate d) {
        return year == d.year && month == d.month && day == d.day;
    }

    @Override
    public String toString() {
        return year +
                "年" + month +
                "月" + day +
                "日";
    }
}

