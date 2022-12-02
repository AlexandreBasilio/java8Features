package com.example.java8.fetures.generics;

public class GenericsMethods {

    //Java Generic Method
    public static <T> boolean isEqual(GenericType<T> g1, GenericType<T> g2){
        return g1.getT().equals(g2.getT());
    }

    public static void main(String args[]){
        GenericType<String> g1 = new GenericType<>();
        g1.setT("Pankaj");

        GenericType<String> g2 = new GenericType<>();
        g2.setT("Pankaj");

        boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);
        //above statement can be written simply as
        isEqual = GenericsMethods.isEqual(g1, g2);
        //This feature, known as type inference, allows you to invoke a generic method as an ordinary method,
        // without specifying a type between angle brackets.
        //Compiler will infer the type that is needed
    }
}
