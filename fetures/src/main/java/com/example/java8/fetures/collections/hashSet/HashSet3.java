package com.example.java8.fetures.collections.hashSet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
/*
Implements Set Interface.
The underlying data structure for HashSet is Hashtable.
As it implements the Set Interface, duplicate values are not allowed.
Objects that you insert in HashSet are not guaranteed to be inserted in the same order. Objects are inserted based on their hash code.
NULL elements are allowed in HashSet.
HashSet also implements Serializable and Cloneable interfaces.

All the classes of Set interface are internally backed up by Map.
HashSet uses HashMap for storing its object internally
the value we insert in HashSet acts as a KEY to the map Object a
and for its value, java uses a constant variable. So in the key-value pair, all the values will be the same.
 */
public class HashSet3 {
    public static void main(String[] args) {
        HashSet<Book> set = new HashSet<Book>();
        //Creating Books
        Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
        //Adding Books to HashSet
        set.add(b1);
        set.add(b2);
        set.add(b3);
        //Traversing HashSet
        set.forEach(book -> System.out.println(book));
    }
}

@Data
@AllArgsConstructor
class Book {
    int id;
    String name,author,publisher;
    int quantity;
}
