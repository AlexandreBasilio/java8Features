package com.example.java8.fetures.ioExamples;

import org.apache.logging.log4j.util.Chars;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamExample {
    public static void main(String[] args) throws Exception
    {
        InputStream input = null;
        try {

            input = new FileInputStream("src/main/resources/Text2.txt");

            // read() method - reading and printing Characters
            // one by one
            int read = input.read(); // valor tab ascii
            System.out.println("Char - "+ Character.toString(read) + " read=" + read);
            System.out.println("Char - "+(char)input.read());

            // mark() - read limiting the 'input' input stream
            input.mark(7);  // ? nao entendi!!!

            // skip() - it results in skipping of 'e' in Ge'e'ksforGeeks
            input.skip(3);
            System.out.println("skip() method comes to play");
            System.out.println("mark() method comes to play");
            System.out.println("Char - "+(char)input.read());
            System.out.println("Char - "+(char)input.read());

            boolean check = input.markSupported();
            if (input.markSupported())  // ? nao entendi!!!
            {
                // reset() method - repositioning the stream to
                // marked positions.
                input.reset();
                System.out.println("reset() invoked");
                System.out.println("Char - "+(char)input.read());
                System.out.println("Char - "+(char)input.read());
            }
            else
                System.out.println("reset() method not supported.");


            System.out.println("input.markSupported() supported"+
                    " reset() - "+check);

        }
        catch(Exception e)
        {
            // in case of I/O error
            e.printStackTrace();
        }
        finally
        {
            if (input!=null)
            {
                // Use of close() - closing the file
                // and releasing resources
                input.close();
            }
        }
    }
}
