package com.example.java8.fetures.generics;

import lombok.Data;

@Data
public class GenericTypeOld {
    private Object t;

    public static void main(String args[]){
        GenericTypeOld type = new GenericTypeOld();
        type.setT(1);
        String str = (String) type.getT(); //type casting, error prone and can cause ClassCastException
    }
}
