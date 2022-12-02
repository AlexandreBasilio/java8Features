package com.example.java8.fetures.pattern.iteratorPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
simple POJO class
 */
@Data
@AllArgsConstructor
public class Channel {

    private double frequency;
    private ChannelTypeEnum type;
}
