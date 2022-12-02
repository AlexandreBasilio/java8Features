package com.example.java8.fetures.pattern.iteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {

    private List<Channel> channelList = new ArrayList<>();

    @Override
    public void addChannel(Channel c) {
        channelList.add(c);
    }

    @Override
    public void removeChanel(Channel c) {
        channelList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type, channelList);
    }

    @Override
    public List<Channel> getChannelList() {
        return channelList;
    }

    // innerClass
    // Notice the inner class implementation of iterator interface so that the implementation can’t be used by any other collection.
    // Same approach is followed by collection classes also and all of them have inner class implementation of Iterator interface
    public class ChannelIteratorImpl implements ChannelIterator {

        private ChannelTypeEnum type;
        private List<Channel> channels;
        private int position;

        public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channels) {
            this.type = type;
            this.channels = channels;
        }

        @Override
        public boolean hasNext() {
            while (position < channels.size()) {
                Channel c = channels.get(position);
                if (c.getType().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
                    return true;
                } else {
                    position++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c = channels.get(position);
            position++;
            return c;
        }
    }
}
