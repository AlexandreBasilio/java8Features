package com.example.java8.fetures.clone.deepClonning;

import java.util.HashMap;
import java.util.Map;

/*
IMPORTANT:
   using clone() will create a DEEP COPIA

   uma copia eh feita no inicio mas tudo eh separado. eles sao REALMENTE INDEPENDENTES !!!
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

        // clone employee emp to clonedEmp
        Employee clonedEmp = (Employee) emp.clone();

        // Objects EMP and CLONEDEMP are DIFERENTS
        System.out.println("emp and clonedEmp == test: " + (emp == clonedEmp) +
                " pointerEmp=" + emp.toString() +
                " pointerCloned=" + clonedEmp.toString() );
        System.out.println("");

        // Conteudo dos Objects EMP and CLONEDEMP sao DIFERENTES
        System.out.println("emp and clonedEmp HashMap == test: " + (emp.getProps() == clonedEmp.getProps()));
        System.out.println("emp.getProps()=" + emp.getProps().toString()+ " clonedEmp.getProps()=" + clonedEmp.getProps().toString());
        System.out.println("empName=" + emp.getName() + " clonedEmp=" + clonedEmp.getName() + " " + (emp.getName() == clonedEmp.getName()));
        System.out.println("emp and clonedEmp Id == test: " + (emp.getId() == clonedEmp.getId()));
        System.out.println("");

        // Let's see the effect of using default cloning

        // change emp props
        emp.getProps().put("title", "CEO");
        emp.getProps().put("city", "New York");
        System.out.println("clonedEmp props:" + clonedEmp.getProps());
        System.out.println("emp props:" + emp.getProps());

        // change name
        clonedEmp.setName("new");
        System.out.println("emp name:" + emp.getName());
        System.out.println("clonedEmp name:" + clonedEmp.getName());
        System.out.println("");

        // change id
        emp.setId(new Integer(2));
        System.out.println("emp id:" + emp.getId());
        System.out.println("clonedEmp id:" + clonedEmp.getId());
        System.out.println("");
    }

}
