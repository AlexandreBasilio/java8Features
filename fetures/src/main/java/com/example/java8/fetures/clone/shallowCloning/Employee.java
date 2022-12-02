package com.example.java8.fetures.clone.shallowCloning;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/*
 to use Java Object clone() method, you have to implement the java.lang.Cloneable marker interface.
 Otherwise, it will throw CloneNotSupportedException at runtime.
 Also Object clone is a protected method, so you will have to override it.
  Let’s look at Object cloning in Java with an example program.

  If our Employee class won’t implement Cloneable interface,
   the program tahat use Employee will throw CloneNotSupportedException runtime exception.


 The default implementation of Java Object clone() method is using shallow copy.
 It’s using reflection API to create the copy of the instance. The below code snippet showcase the shallow cloning implementation.

 HERE WE HAVE DEFAULT IMPLEMENTATION
 */
@Getter
@Setter
public class Employee implements Cloneable {

    private Integer id;
    private String name;
    private Map<String, String> props;

    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone();
        // ou isso
        Employee e = new Employee();
        e.setId(this.id);
        e.setName(this.name);
        e.setProps(this.props);
        return e;
    }
}
