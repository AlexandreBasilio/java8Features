package com.example.java8.fetures.collections.comparableAndComparator.withUserDefinedObjects;

import java.util.Comparator;
/*
Here is the separate class implementation of Comparator interface
that will compare two Employees object first on their id and if they are same then on the name.
 */
public class EmployeeComparatorByIdAndName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int flag = o1.getId() - o2.getId();
        if(flag==0) flag = o1.getName().compareTo(o2.getName());
        return flag;
    }
}
