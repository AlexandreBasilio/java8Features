package com.example.java8.fetures.clone.withSerialization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/*

 */
@Getter
@Setter
public class Employee implements Serializable {

    private Integer id;
    private String name;
    private Map<String, String> props;
}
