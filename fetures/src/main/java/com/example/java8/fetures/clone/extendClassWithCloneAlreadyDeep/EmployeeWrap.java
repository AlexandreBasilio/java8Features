package com.example.java8.fetures.clone.extendClassWithCloneAlreadyDeep;

import lombok.Getter;
import lombok.Setter;

/*
The EmployeeWrap class doesn’t have any mutable properties and it’s utilizing superclass clone() method implementation.
If there are mutable fields, then you will have to take care of deep copying of only those fields.
Here is a simple program to test if this way of cloning works fine or not.

 */
@Setter
@Getter
public class EmployeeWrap extends Employee implements Cloneable {

    private String title;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // aqui estah chamando da classe Employee que ja ta implementado com deep
    }
}
