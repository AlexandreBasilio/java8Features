package com.example.java8.fetures.clone.shallowCloning;

import java.util.HashMap;
import java.util.Map;

/*
IMPORTANT:
   using clone() will create a SHALLOW COPIA (COPIA RASA)
    eh criado um outro objeto: o objeto pai e clone sao diferentes (tem ponteiros diferentes, mas
    as variaveis de ambos os objetos apontam para o mesmo objeto.
     - A variable para o MAP, se alterado o conteudo, altera para as dois objetos
         PROBLEM: serious data integrity issue if we change the underlying object value.
                  Any change in the value might get reflected to the cloned instance too.;

                  It can be a problem when you want to create totally detached objects through cloning process.
                  This can lead to unwanted results, hence the need to properly override the Object clone() method.

        PROBLEM : Uma copia feita, mas as variaveis apontam para o mesmo obj. muda o valor de uma variavel muda para o outro objeto
                  As excecoes sao as variaveis de tipo primitivo que sao IMMUTABLES (nao mudam)
                  ex tipos IMMUTABLES: String, primitive types.

        SOLUTION: with clone() use always only PRIMITIVE and IMMUTABLE variables in the OBJECT

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
        // Quando vc clona os objetos sao distintos (dois pointers).
        // Uma copia feita, mas as variaveis apontam para o mesmo obj. muda o valor de uma variavel muda para o outro objeto
        // As excecoes sao as variaveis de tipo primitivo que sao IMMUTABLES (nao mudam)
        //ex tipos IMMUTABLES: String, primitive types.
        Employee clonedEmp = (Employee) emp.clone();  // shallow copy. (copia rasa)

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
