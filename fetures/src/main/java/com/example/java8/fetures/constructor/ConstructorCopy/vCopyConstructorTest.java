package com.example.java8.fetures.constructor.ConstructorCopy;

import java.util.ArrayList;
import java.util.List;

public class vCopyConstructorTest {

    public static void main(String[] args) {
        List<String> fl = new ArrayList<>();
        fl.add("Mango");
        fl.add("Orange");

        Fruits fr = new Fruits(fl);

        System.out.println("Obj original=" + fr.getFruitsList());

        // os dois objetos apontam para o mesmo pointer! Quando muda em 1 muda no outro
        // MESMO PONTEIRO. as duas variaveis apontam para o mesmo OBJETO
        Fruits frCopy = fr;
        frCopy.getFruitsList().add("Apple");

        System.out.println("frCopy obj copiado + apple=" + frCopy.getFruitsList() + "  pointer=" + frCopy.toString());
        System.out.println("fr obj copiado + apple=" + fr.getFruitsList() + " pointer=" + fr.toString());

        fr.getFruitsList().add("kiwi");
        System.out.println("frCopy obj copiado + apple=" + frCopy.getFruitsList() + " pointer=" + frCopy.toString());
        System.out.println("fr obj copiado + apple=" + fr.getFruitsList() + " pointer=" + fr.toString());

        System.out.println(" ");
        System.out.println(" ");

        // deep copy  to return the copy of the object. (objects separés)
        frCopy = new Fruits(fr);
        frCopy.getFruitsList().add("Banana");
        System.out.println(fr.getFruitsList() + " pointer=" + fr.toString());
        System.out.println(frCopy.getFruitsList() + " pointer=" + frCopy.toString());

    }
}
