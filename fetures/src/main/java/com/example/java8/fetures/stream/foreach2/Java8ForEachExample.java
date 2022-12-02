package com.example.java8.fetures.stream.foreach2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachExample {

    public static void main (String[] args) {

        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++) myList.add(i);

//        //traversing using Iterator
//        Iterator<Integer> it = myList.iterator();
//        while(it.hasNext()){
//            Integer i = it.next();
//            System.out.println("Iterator Value::"+i);
//        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("for" + integer);
            }
        });

        myList.forEach(t -> {
            t+=10;
            System.out.println("forEach LAMBDA anonymous class Value::" + t);
        });

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

    }
}

// The number of lines might increase
// but forEach method helps in having the logic for iteration and business logic at separate place resulting in higher separation of concern and cleaner code.

// Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic.
// The forEach method takes java.util.function.Consumer object as an argument,
// so it helps in having our business logic at a separate location that we can reuse. Let’s see forEach usage with a simple example.

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::"+t);
    }
}
