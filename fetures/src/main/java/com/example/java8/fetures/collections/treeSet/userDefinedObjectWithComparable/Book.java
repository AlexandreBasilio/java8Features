package com.example.java8.fetures.collections.treeSet.userDefinedObjectWithComparable;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
TreeSet example where we are adding books to the set and printing all the books.
 The elements in TreeSet must be of a Comparable type. String and Wrapper classes are Comparable by default.
 To add user-defined objects in TreeSet, you need to implement the Comparable interface, if not tyou have a exception
  in runtime (Exception in thread "main" java.lang.ClassCastException)
 */
@Data
@AllArgsConstructor
public class Book implements Comparable<Book>{
    int id;
    String name,author,publisher;
    int quantity;

    @Override
    public int compareTo(Book b) {
        if(id>b.id){
            return 1;
        }else if(id<b.id){
            return -1;
        }else{
            return 0;
        }
    }
}
