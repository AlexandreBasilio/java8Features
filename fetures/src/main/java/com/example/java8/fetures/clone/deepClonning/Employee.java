package com.example.java8.fetures.clone.deepClonning;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 to use Java Object clone() method, you have to implement the java.lang.Cloneable marker interface.
 Otherwise, it will throw CloneNotSupportedException at runtime.
 Also Object clone is a protected method, so you will have to override it.
  Let’s look at Object cloning in Java with an example program.

  If our Employee class won’t implement Cloneable interface,
   the program tahat use Employee will throw CloneNotSupportedException runtime exception.


 Deep cloning, we have to copy fields one by one.
 If we have a field with nested objects such as List, Map, etc. then we have to write the code to copy them too one by one.
  That’s why it’s called deep cloning or deep copy.
   We can override the Employee clone method for use a deep cloning.

 HERE WE HAVE DEEP CLONNING

 In most of the cases, this is what we want. The clone() method should return a new object totally detached from the original instance.
 */
@Getter
@Setter
public class Employee implements Cloneable {

    private Integer id;
    private String name;
    private Map<String, String> props;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //utilize clone Object method

        Employee emp = (Employee) obj;

        // deep cloning for mmutable fields
        Map<String, String> hm = new HashMap<>();
        props.forEach((k, v) -> hm.put(k,v));
        emp.setProps(hm);

        return emp;
    }
}
