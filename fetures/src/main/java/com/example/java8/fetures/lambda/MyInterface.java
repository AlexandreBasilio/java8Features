package com.example.java8.fetures.lambda;

public interface MyInterface {

    void abstract_func(int x, int y);

    default void default_Fun() {
        System.out.println("this is a default method");
    }

}
