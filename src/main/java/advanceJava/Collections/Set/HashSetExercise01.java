package advanceJava.Collections.Set;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Chris Yang
 * created 2022-03-29 14:43
 **/
public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<>();
        set.add(new Employee("Jack", 36));
        set.add(new Employee("Rose", 35));
        set.add(new Employee("Jack", 46));
        set.add(new Employee("Jack", 36));
        System.out.println("set = " + set);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }


    // 确保hash值的唯一
    public int hashCode(){
        return Objects.hash(name,age);
    }

    // 确保值的唯一
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
