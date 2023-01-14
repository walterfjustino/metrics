package com.metric.app.service;

import com.metric.app.model.Metric;

public interface MetricStore {
    /**
     * Store a metric
     * @param metric
     */
    void insert(Metric metric) throws Exception;

    /**
     * Remove all metrics of `name`
     * @param name
     */
    void removeAll(String name);

    /**
     * Retrieve an iterator for metrics of `name` in the specified range
     * @param name      the name of the queried metrics
     * @param from      start timestamp (inclusive)
     * @param to        end timestamp (exclusive)
     * @return the iterator
     */
    MetricIterator query(String name, long from, long to);}