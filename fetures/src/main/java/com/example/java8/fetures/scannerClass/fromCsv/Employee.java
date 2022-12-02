package com.example.java8.fetures.scannerClass.fromCsv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Employee {

    private int code;
    private String nome;
    private String cargo;

}
