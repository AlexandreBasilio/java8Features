package com.example.java8.fetures.scannerClass.fromCsv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("src/main/resources/employees.csv"));
            fileScanner.useDelimiter(System.getProperty("line.separator"));

            List<Employee> employees = new ArrayList<>();

            while (fileScanner.hasNext()) {  // hasNext() - returns true if there is another token in the input.
                employees.add(parseEmployee(fileScanner));
            }
            employees.stream()
                    .forEach(employee -> System.out.println(employee.getCode() + " " +
                                    employee.getNome() +
                                    employee.getCargo()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Employee parseEmployee(Scanner fileScanner) {
        Scanner scEmp = new Scanner(fileScanner.next());
        scEmp.useDelimiter(",");
        return Employee.builder()
                .code(scEmp.nextInt()) // nextInt() - returns the next token int from the scanner
                .nome(scEmp.next())  // next() - returns the next token from the scanner
                .cargo(scEmp.next()) // next() - returns the next token from the scanner
                .build();
    }
}
