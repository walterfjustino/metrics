package com.metric.app.repository;

import com.metric.app.model.Metric;
import com.metric.app.service.MetricIterator;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends MetricStore {

  @Override
  void insert(Metric metric) throws Exception;

  @Override
  void removeAll(String name);

  @Override
  MetricIterator query(String name, long from, long to);
}
