package advanceJava.Collections.MapTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Chris Yang
 * created 2022-04-09 22:44
 **/
public class MapExcercise {
    public static void main(String[] args) {

        Map hashMap = new HashMap<>();

        hashMap.put(1, new Emp("Jack", 300000, 1));
        hashMap.put(2, new Emp("Tom", 1000, 2));
        hashMap.put(3, new Emp("Milan", 12000, 3));

        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            Emp emp = (Emp) hashMap.get(key);
            if (emp.getSal() > 10000) {
                System.out.println(emp);
            }
        }

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Emp emp = (Emp) entry.getValue();
            if (emp.getSal() > 10000) {
                System.out.println(emp);
            }
        }
    }
}

class Emp {
    private String name;
    private double sal;
    private int id;

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
