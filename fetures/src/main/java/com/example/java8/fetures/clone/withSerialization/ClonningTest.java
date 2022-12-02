package com.example.java8.fetures.clone.withSerialization;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.SerializationUtils;

/*
  One way to easily perform deep cloning is through serialization.
  But serialization is an expensive procedure and your class should implement Serializable interface.
  All the fields and superclasses must implement Serializable too.

  Using Apache Commons Util
  If you are already using Apache Commons Util classes in your project and your class is serializable, then use the below method.
 */

public class ClonningTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        // create employee emp
        Employee emp = new Employee();

        emp.setId(new Integer(1));
        emp.setName("Pankaj");

        Map<String, String> props = new HashMap<>();
        props.put("salary", "10000");
        props.put("city", "Bangalore");
        emp.setProps(props);

        // clone employee emp to clonedEmp using apache commons-lang3
        Employee clonedEmp = (Employee) SerializationUtils.clone(emp);

        // Objects EMP and CLONEDEMP are DIFERENTS
        System.out.println("emp and clonedEmp == test: " + (emp == clonedEmp) +
                " pointerEmp=" + emp.toString() + " " + emp.hashCode() +
                " pointerCloned=" + clonedEmp.toString() + " " + clonedEmp.hashCode());
        System.out.println("");

        // Conteudo dos Objects EMP and CLONEDEMP sao IGUAIS
        System.out.println("emp and clonedEmp HashMap == test: " + (emp.getProps() == clonedEmp.getProps()));
        System.out.println("emp.getProps()=" + emp.getProps().hashCode() + " clonedEmp.getProps()=" + clonedEmp.getProps().hashCode());
        System.out.println("empName=" + emp.getName() + " clonedEmp=" + clonedEmp.getName());
        System.out.println("emp and clonedEmp Id == test: " + (emp.getId() == clonedEmp.getId()));
        System.out.println("");

        // Let's see the effect of using default cloning

        // change emp props
        emp.getProps().put("title", "CEO");
        emp.getProps().put("city", "New York");
        System.out.println("clonedEmp props:" + clonedEmp.getProps());
        System.out.println("emp props:" + emp.getProps());

        // change emp name
        clonedEmp.setName("new");
        System.out.println("emp name:" + emp.getName());
        System.out.println("clonedEmp name:" + clonedEmp.getName());
        System.out.println("");

        // change id
        emp.setId(new Integer(2));
        System.out.println("emp id:" + emp.getId());
        System.out.println("clonedEmp id:" + clonedEmp.getId());
        System.out.println("");

        System.out.println("emp and clonedEmp HashMap == test: " + (emp.getProps() == clonedEmp.getProps()));

    }

}
