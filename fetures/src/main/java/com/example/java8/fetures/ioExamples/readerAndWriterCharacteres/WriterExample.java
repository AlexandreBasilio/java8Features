package com.example.java8.fetures.ioExamples.readerAndWriterCharacteres;

import org.apache.logging.log4j.util.Chars;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
    public static void main(String args[]) {

        String data = "comeco jjjjbasilioHello Geeks. fds fgsg g gsdfg"  + Chars.LF +
                "galexd" + Chars.LF +
                "gdfg " + Chars.LF +
                "gdfg" + Chars.LF +
                "ioifim";

        try {
            // Creates a Writer using FileWriter
            Writer output = new FileWriter("src/main/resources/file.txt");

            // Writes string to the file
            output.write(data);
            output.append(Chars.LF + data); // CharSequence is like a String

            // Closes the writer
            output.close();
        }

        catch (IOException e) {
           // e.getStackTrace();
            System.err.println("erro=" + e.getMessage());
        }
    }
}
