package com.example.java8.fetures.generics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@SuppressWarnings("rawtypes")
public class GenericType<T> {

    private T t;

    public static void main(String[] args) {
        GenericType type = new GenericType<>();
        type.setT("dasfas");
        type.setT(1); // valid and autoboxing support
    }
}
