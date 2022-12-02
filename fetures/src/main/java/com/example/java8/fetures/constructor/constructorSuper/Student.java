package com.example.java8.fetures.constructor.constructorSuper;

public class Student extends Person {

    private String name;

    public Student() {
        System.out.println("Student Created");
    }

    public Student(int i, String n) {
        super(i); // super class constructor called
        this.name = n;
        System.out.println("Student Created with name = " + n);
    }

}
