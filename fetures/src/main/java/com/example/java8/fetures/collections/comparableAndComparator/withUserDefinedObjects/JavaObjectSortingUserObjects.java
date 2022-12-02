package com.example.java8.fetures.collections.comparableAndComparator.withUserDefinedObjects;

import java.util.Arrays;

public class JavaObjectSortingUserObjects {

    public static void main(String[] args) {

        //sorting object array
        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);

        //sorting employees array using Comparable interface implementation
        // we have an exception:
        //   Exception in thread "main" java.lang.ClassCastException:
        //   class com.example.java8.fetures.collections.comparableAndComparator.withUserDefinedObjects.Employee
        //   cannot be cast to class java.lang.Comparable
        //
        //  Java provides Comparable interface which should be implemented
        //  by any custom class if we want to use Arrays or Collections sorting methods.
        //
        //  The Comparable interface has compareTo(T obj) method which is used by sorting methods,
        //  you can check any Wrapper, String or Date class to confirm this.
        //
        // We should override this method in such a way that it returns a negative integer, zero, or a positive integer
        //  if “this” object is less (-1) than, equal to (0), or greater (1) than the object passed as an argument.
        //
        //
        // Employee must implement Comparable to work
        Arrays.sort(empArr);
        System.out.println("Default Sorting of Employees list:\n"+Arrays.toString(empArr));

        // sort with Comparator
        /*
        We don’t need to make any code changes at client side for using Comparable,
         Arrays.sort() or Collection.sort() methods automatically uses the compareTo() method of the class.
          For Comparator, client needs to provide the Comparator class to use in compare() method.
         */
        Arrays.sort(empArr, Employee.SalaryComparator);
        System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

        // sort with Comparator
        Arrays.sort(empArr, Employee.AgeComparator);
        System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

        // sort with Comparator
        Arrays.sort(empArr, Employee.NameComparator);
        System.out.println("Employees list sorted by Salary:\n"+Arrays.toString(empArr));

        //Employees list sorted by ID and then name using Comparator class
        empArr[0] = new Employee(1, "Mikey", 25, 10000);
        Arrays.sort(empArr, new EmployeeComparatorByIdAndName());
        System.out.println("Employees list sorted by ID and Name:\n"+Arrays.toString(empArr));

    }
}
