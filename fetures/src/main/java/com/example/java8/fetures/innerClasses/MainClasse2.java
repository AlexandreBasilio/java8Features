package com.example.java8.fetures.innerClasses;

import org.junit.jupiter.api.Test;

/*
We can define a local inner class inside any block too, such as static block, if-else block etc.
However, in this case, the scope of the class will be very limited.
 */
public class MainClasse2 {

    static {
        class Foo {

        }
        Foo f = new Foo();
    }

    public void bar() {
        if(1 < 2) {
            class Test {

            }
            Test t = new Test();
        }
        // Below will throw error because of the scope of the class
        //Test t = new Test();
        //Foo f = new Foo();
        class Test2 {

        }
        Test2 t = new Test2();

    }
}

class Test3 {

}
