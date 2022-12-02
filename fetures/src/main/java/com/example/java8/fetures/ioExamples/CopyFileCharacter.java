package com.example.java8.fetures.ioExamples;

import java.io.*;

public class CopyFileCharacter {

    public static void main(String args[]) throws IOException {
        // Creates a character array of size 100.
        char[] buffer = new char[10000]; // when you read you put the data into the array

        // Creating a reader object using the class FileReader
        Reader input = null;
        Writer output = null;
        try {
            input = new FileReader("src/main/resources/input.txt");
            output = new FileWriter("src/main/resources/output.txt");

            // Checks if reader is ready (existem dados.. se nao existir retorna false)
            System.out.println("Is there data in the stream?  " + input.ready());

            if (input.ready()) {
                // Reads characters
                //input.read(); // read a single character. Does not work here
                input.read(buffer);

                // Write characters
                output.write(buffer);
            }

            input.close();
            output.close();
            // input.read(array); // exception stream closed

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("erro=" + e.getMessage());
        }

    }
}

