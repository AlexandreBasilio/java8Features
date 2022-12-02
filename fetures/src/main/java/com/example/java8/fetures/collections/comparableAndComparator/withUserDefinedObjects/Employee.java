package com.example.java8.fetures.collections.comparableAndComparator.withUserDefinedObjects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int age;
    private long salary;

    /*
    . We should override this method in such a way that it returns a negative integer, zero, or a positive integer
     if “this” object is less than, equal to, or greater than the object passed as an argument.
     */
    @Override
    public int compareTo(Employee o) {
        return (this.id - o.id);
    }

    /*
        Comparator interface compare(Object o1, Object o2) method need to be implemented
         be implemented in such a way that it returns :
            negative int if the first argument is less than the second one
            returns zero if they are equal
            return positive int if the first argument is greater than the second one.
     */
     // we can use  anonymous classes to implement the methods os interface comparator

    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int) (o1.getSalary() - o2.getSalary());
        }
    };

    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (o1.getAge() - o2.getAge());
        }
    };

    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (o1.getName().compareTo(o2.getName()));
        }
    };

}
