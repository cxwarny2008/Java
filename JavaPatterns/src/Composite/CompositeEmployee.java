package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式-部分与整体
 */
public class CompositeEmployee {
    private String name;
    private String dept;
    private int salary;
    private List<CompositeEmployee> subordinates;

    public CompositeEmployee(String name, String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<CompositeEmployee>();
    }

    public void add(CompositeEmployee e) {
        subordinates.add(e);
    }

    public void remove(CompositeEmployee e) {
        subordinates.remove(e);
    }

    public List<CompositeEmployee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return ("Employee : [ Name : " + name + ", dept : " + dept + ", salary : " + salary + " ]");
    }

}
