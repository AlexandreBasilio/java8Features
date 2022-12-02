package com.example.java8.fetures.stream.foreach;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> subList = new ArrayList<String>();
        subList.add("Carrot");
        subList.add("Potato");
        subList.add("Cauliflower");
        subList.add("LadyFinger");
        subList.add("Tomato");
        System.out.println("------------Vegetable List--------------");
        //subList.forEach(sub -> System.out.println(sub));
        subList.forEach(s -> System.out.println(s));
    }
}
