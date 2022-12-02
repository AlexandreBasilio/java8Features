package com.example.java8.fetures.pattern.iteratorPattern;

import java.util.List;

/*
ChannelCollection interface defines the CONTRACT for our collection class implementation.
Notice that there are methods to add and remove a channel but there is no method that returns the list of channels.
ChannelCollection has a method that returns the iterator for traversal. ChannelIterator interface
 */
public interface ChannelCollection {

    void addChannel(Channel c);

    void removeChanel(Channel c);

    ChannelIterator iterator(ChannelTypeEnum type);

    List<Channel>  getChannelList();

}
