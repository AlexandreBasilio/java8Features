package com.example.java8.fetures.constructor.ConstructorCopy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Fruits {

    private List<String> fruitsList;

    // deep copy to return the copy of the object. (objects separés)
    // copy constructor
    public Fruits(Fruits fr) {
        List<String> fl = new ArrayList<>();
//        for (String f : fr.getFruitsList()) {
//            fl.add(f);
//        }
        fr.getFruitsList().stream().forEach(s -> fl.add(s));
        this.fruitsList = fl;
    }

}
