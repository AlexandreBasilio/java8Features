package com.example.java8.fetures.ioExamples.readerAndWriterCharacteres;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*

A reader is used when a user wants to read character-based data from a source of the data.
The Java IO Reader class is an abstract class that is used for expressing character streams.
The only programs that a subclass needs to implement are read(char[], int, int) and close() methods.
Many subclasses of the Reader class will override some of the methods shown below.
However, most subclasses produce tremendous efficiency, additional functionality, or both.

 */
public class ReaderExample {
    public static void main(String[] args) {
        System.out.println("debut");

        // Creates a character array of size 100.
        char[] buffer = new char[1000]; // when you read you put the data into the array

        // Creating a reader object using the class FileReader
        Reader input = null;
        try {
            input = new FileReader("src/main/resources/file.txt");

            // Checks if reader is ready (existem dados.. se nao existir retorna false)
            System.out.println("Is there data in the stream?  " + input.ready());

            // Reads characters
            //input.read(); // read a single character. Does not work here
            input.read(buffer);
            System.out.println("Data in the stream:");
            System.out.println(buffer);
            System.out.println(buffer);
            input.read(buffer);
            System.out.println(buffer);

            input.close();
           // input.read(array); // exception stream closed

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("erro=" + e.getMessage());
        }

    }
}
