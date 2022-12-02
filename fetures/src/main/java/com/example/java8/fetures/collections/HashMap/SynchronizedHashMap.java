package com.example.java8.fetures.collections.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
HashMap is unsynchronized i.e. multiple threads can access it simultaneously.
 If multiple threads access this class simultaneously and at least one thread manipulates it structurally then
 it is necessary to make it synchronized externally. It is done by synchronizing some object which encapsulates the map.
 If No such object exists then it can be wrapped around Collections.synchronizedMap()
 */
public class SynchronizedHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        // populate the map
        map1.put("Value1", "20");
        map1.put("Value2", "30");
        map1.put("Value3", "40");

        System.out.println("map="+ map1);

        // The synchronizedMap() method return a synchronized (thread-safe) map backed by the specified map.
        // logo toda mudanca feita no hasMap vai reflatir diretament no syncMap
        // Parameters: This method takes the map as a parameter to be “wrapped” in a synchronized map.
        var synMap = Collections.synchronizedMap(map1);

        map1.put("Value5", "50");

        System.out.println("synMap="+ map1);
    }

}
