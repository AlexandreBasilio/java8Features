package com.example.java8.fetures.serialization;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Notice that it’s a simple java bean with some properties and getter-setter methods.
 If you want an object property TO BE NOT SERIALIZED o be not serialized to stream, you can use TRANSIENT keyword like I have done with salary variable.

 Now suppose we want to write our objects to file and then deserialize it from the same file.
  So we need utility methods that will use:
    ObjectInputStream and ObjectOutputStream for serialization purposes.

  serialVersionUID:
. Java uses class variables, methods, class name, package etc to generate this unique long number.
 */
@Getter
@Setter
public class Employee implements Serializable {

    private static final long serialVersionUID = 9060395807362556111L;

    private int id;
    private String name;
    private int salary; // will NOT BE SERIALIZED
    private String password;
    private String cargo;

    @Override
    public String toString() {
        return "Employee{name=" + name + ",id=" + id + ",salary=" + salary + "}";
    }

    // Serializable faz tudo automatico, mas posso fazer truques manuais (4 methods below)


    // If this method is present, then after deserialization process, this method is called to return the final object to the caller program.
    protected Object readResolve() {
        System.out.println("this readResolve=" + this);
        return this;
    }

    // If this method is present, then after serialization process this method is called and the object returned is serialized to the stream.
    protected Object writeReplace() {
        System.out.println("this writeReplace=" + this);
        this.salary = 8888;
        return this;
    }

    /*
     This method will be executed automatically by the jvm(also known as Callback Methods) at the time of deserialization.
      Hence to perform any activity during deserialization, it must be defined only in this method.
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("read Object=" + ois);
        // performing default deserialization of Employee object
        ois.defaultReadObject();
    }


    private void writeObject(ObjectOutputStream oos) throws Exception {
        System.out.println("write Object=" + oos);
        // to perform default serialization of Account object.
        oos.defaultWriteObject();
    }
}