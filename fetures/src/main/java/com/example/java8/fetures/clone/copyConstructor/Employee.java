package com.example.java8.fetures.clone.copyConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/*
We can define a copy constructor to create a copy of the object. Why to depend on the Object clone() method at all?
For example, we can have an Employee copy constructor like the following code.
 */
@Getter
@Setter
@NoArgsConstructor
public class Employee  {

    private Integer id;
    private String name;
    private Map<String, String> props;

    public Employee(Employee emp) {
        this.setId(emp.getId());
        this.setName(emp.getName());

        // deep cloning for mmutable fields
        Map<String, String> hm = new HashMap<>();
        emp.getProps().forEach((k, v) -> hm.put(k,v));
        this.setProps(hm);
    }
}
