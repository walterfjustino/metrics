package com.metric.app.model;

/**
 * Basic implementation of the Metric abstraction
 */
public class Metric {
    private final String name;
    private final long timestamp;

    public Metric(String name, long timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public long getTimestamp() {
        return timestamp;
    }

//    @Override
//    public boolean moveNext() {
//
//        return false;
//    }
//
//    @Override
//    public Metric current() {
//         return null;
//    }
//
//    @Override
//    public void remove() {
//
//    }
//
//    @Override
//    public void close() throws Exception {
//
//    }
}