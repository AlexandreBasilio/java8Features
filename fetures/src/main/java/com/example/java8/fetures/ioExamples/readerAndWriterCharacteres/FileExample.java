package com.example.java8.fetures.ioExamples.readerAndWriterCharacteres;

import java.io.File;

/*

The Java IO File class is Java’s description of a file or pathname of a directory.
 Since file and directory names have distinctive arrangements on various platforms,
  a naive string is not sufficient to describe them.
  The File class comprises various approaches for operating with the pathname, removing and renaming files,
generating new directories, arranging the contents of a list, and managing numerous general properties of files and directories.

Instances of the File class are immutable. That is, once created, the abstract pathname denoted by a File object will nevermore change
 */
public class FileExample {

    public static void main(String[] args) {

        // taking the file or directory as a input
        // from the command line argument (args)
        String fname = "src/main/resources/file.txt";

        // passing the file or directory name to File object
        File f = new File(fname);

        // applying the methods of the File
        // class on the File object
        System.out.println("Can Execute - "+f.canExecute());
        System.out.println("File name - "+f.getName());
        System.out.println("Path - "+f.getPath());
        System.out.println("Absolute path - " +f.getAbsolutePath());
        System.out.println("Parent - "+f.getParent());
        System.out.println("Exists - "+f.exists());

        if(f.exists())
        {
            System.out.println("Is writable - "+f.canWrite());
            System.out.println("Is readable - "+f.canRead());
            System.out.println("Is a directory - "+f.isDirectory());
            System.out.println("File Size in bytes "+f.length());
        }
    }
}
