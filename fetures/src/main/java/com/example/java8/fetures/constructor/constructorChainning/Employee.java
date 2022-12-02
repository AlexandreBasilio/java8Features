package com.example.java8.fetures.constructor.constructorChainning;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;
    private String name;

    public Employee() {
        this("John Doe", 999);
        System.out.println("Default Employee Created");
    }

    public Employee(int i) {
        this("John Doe", i);
        System.out.println("Employee Created with Default Name");
    }
    public Employee(String s, int i) {
        this.id = i;
        this.name = s;
        System.out.println("Employee Created");
    }

    @Override
    public String toString() {
        return "id="+id+" nome="+name;
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println(emp);
        Employee emp1 = new Employee(10);
        System.out.println(emp1);
        Employee emp2 = new Employee("Pankaj", 20);
        System.out.println(emp2);
    }
}
