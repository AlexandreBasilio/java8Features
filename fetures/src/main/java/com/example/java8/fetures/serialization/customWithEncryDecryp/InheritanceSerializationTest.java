package com.example.java8.fetures.serialization.customWithEncryDecryp;

import com.example.java8.fetures.serialization.SerializationUtil;
import com.example.java8.fetures.serialization.withInheritance.SubCalss;

import java.io.IOException;

public class InheritanceSerializationTest {

    public static void main(String[] args) {
        String fileName = "subclass.ser";

        SubCalss subClass = new SubCalss();
        subClass.setId(10);
        subClass.setValue("Data");
        subClass.setName("Pankaj");

        try {
            SerializationUtil.serializa(subClass, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            SubCalss subNew = (SubCalss) SerializationUtil.deserialize(fileName);
            System.out.println("SubClass read = "+subNew);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
