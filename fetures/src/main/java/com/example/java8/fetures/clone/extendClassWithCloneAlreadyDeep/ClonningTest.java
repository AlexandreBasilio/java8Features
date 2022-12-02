package com.example.java8.fetures.clone.extendClassWithCloneAlreadyDeep;

import java.util.HashMap;
import java.util.Map;

public class ClonningTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        // Usando WRAPPER
        EmployeeWrap empWrap = new EmployeeWrap();
        empWrap.setId(1);
        empWrap.setName("Pankaj");
        empWrap.setTitle("CEO");

        Map<String, String> props = new HashMap<>();
        props.put("salary", "10000");
        props.put("city", "Bangalore");
        empWrap.setProps(props);

        EmployeeWrap clonedEmpWrap = (EmployeeWrap) empWrap.clone();

        empWrap.getProps().put("1", "1");

        System.out.println("empWrap mutable property value = "+empWrap.getProps());

        System.out.println("clonedEmpWrap mutable property value = "+clonedEmpWrap.getProps());

    }

}
