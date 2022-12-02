package com.example.java8.fetures.collections.treeSet;

import java.util.Set;
import java.util.TreeSet;
/*
TreeSet implements the SortedSet interface. So, duplicate values are not allowed.
Objects in a TreeSet are stored in a sorted and ascending order.
TreeSet does not preserve the insertion order of elements but elements are sorted by keys.
If we are depending on the default natural sorting order, the objects that are being inserted into the tree should be
  homogeneous and comparable.
  TreeSet does not allow the insertion of heterogeneous objects.
  It will throw a classCastException at Runtime if we try to add heterogeneous objects.
The TreeSet can only accept generic types which are comparable.
For example, the StringBuffer class implements the Comparable interface
 */


// Java code to illustrate What if Heterogeneous
// Objects are Inserted
public class TreeSet4Example {

    // Main driver method
    public static void main(String[] args)
    {

        // Object creation
        Set<StringBuffer> ts = new TreeSet<>();

        try {
            // Adding elements to above object
            // using add() method
            ts.add(new StringBuffer("A"));
            ts.add(new StringBuffer("Z"));
            ts.add(new StringBuffer("L"));
            ts.add(new StringBuffer("B"));
            ts.add(new StringBuffer("O"));
            ts.add(new StringBuffer(1));
            // ts.add(1);  // compilation error

            // Note: StringBuffer implements Comparable
            // interface

            // Printing the elements
            System.out.println(ts);
        } catch (Exception e) {
            System.out.println("erro");
        }

    }
}
