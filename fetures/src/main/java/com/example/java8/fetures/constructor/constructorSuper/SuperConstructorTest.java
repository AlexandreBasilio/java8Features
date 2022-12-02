package com.example.java8.fetures.constructor.constructorSuper;

public class SuperConstructorTest {

    public static void main(String[] args) {
        /*
          So the call went to the no-args constructor of Student class since
          there was no super call in the first statement
          the no-args or default constructor of Person class is called.
         */
        Student st = new Student();

        /*
          Here, we are explicitly calling superclass constructor, so Java doesn’t need to do any extra work from their side.
         */
        st = new Student(10, "alex");
    }
}
