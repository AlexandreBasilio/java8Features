package com.example.java8.fetures.collections.HashMap;

import java.util.HashMap;

/*
Applications of HashMap: HashMap is mainly the implementation of hashing.
It is useful when we need efficient implementation of search, insert and delete operations.
Please refer to the applications of hashing for details.
 */
public class HashMap1 {
    // Main driver method
    public static void main(String[] args)
    {
        // Create an empty hash map by declaring object
        // of string and integer type
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements to the Map
        // using standard put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vishal", 20);

        // Print size and content of the Map
        System.out.println("Size of map is:- " + map.size());

        // Printing elements in object of Map
        System.out.println(map);

        // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("vishal")) {

            // Mapping
            Integer a = map.get("vishal");

            // Printing value for the corresponding key
            System.out.println("value for key" + " \"vishal\" is:- " + a);
        }
    }
}
