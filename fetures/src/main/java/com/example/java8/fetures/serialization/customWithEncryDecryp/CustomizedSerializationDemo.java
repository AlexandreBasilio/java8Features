package com.example.java8.fetures.serialization.customWithEncryDecryp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomizedSerializationDemo  {
    public static void main(String[] args) throws Exception
    {
        GfgAccount gfg_g1 = new GfgAccount();

        System.out.println("Username :" + gfg_g1.getUsername() +
                "       Password :" + gfg_g1.getPwd());

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // writeObject() method on Account class will
        // be automatically called by jvm
        oos.writeObject(gfg_g1);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        GfgAccount gfg_g2 = (GfgAccount)ois.readObject();

        System.out.println("Username :" + gfg_g2.getUsername() +
                "       Password :" + gfg_g2.getPwd() + " " + gfg_g2.getPerguntaSecreta() + " " + gfg_g2.getChamp1() + " " + gfg_g2.getChamp2());
    }
}
