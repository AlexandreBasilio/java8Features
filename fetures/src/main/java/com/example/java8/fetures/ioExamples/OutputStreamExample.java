package com.example.java8.fetures.ioExamples;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamExample {
    public static void main(String args[]) throws Exception
    {
        OutputStream output
                = new FileOutputStream("src/main/resources/file.txt");
        byte b[] = { 65, 66, 67, 68, 69, 70, 32}; // tab ascii`

        // illustrating write(byte[] b) method
        output.write(b); // write in buffer

        // illustrating flush() method
        output.flush();  // commit tudo que estah no buffer

        // illustrating write(int b) method
        for (int i = 71; i < 75; i++) {
            output.write(i);  // write byte pour byte no buffer
        }

        output.flush(); // commit

        // close the stream
        output.close();
    }
}
