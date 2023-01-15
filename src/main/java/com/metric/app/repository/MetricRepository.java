package com.metric.app.repository;

import com.metric.app.model.IteratorMetric;
import com.metric.app.model.Metric;
import com.metric.app.model.Storage;
import com.metric.app.service.MetricIterator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MetricRepository implements MetricStore {

//  private ConcurrentLinkedDeque<Metric> storage = new ConcurrentLinkedDeque<>();
  @Autowired
  private Storage storage;

  @Autowired
  private IteratorMetric iteratorMetric;


  @Override
  public void insert(Metric metric) throws Exception {
    storage.add(metric);
  }

  @Override
  public void removeAll(String name) {
    var elements = storage.parallelStream()
            .filter(element -> element.getName().equals(name))
            .toList();
    storage.removeAll(elements);

  }

  @Override
  public MetricIterator query(String name, long from, long to) {
    storage.parallelStream()
            .filter(metric -> metric.getName().equals(name) && metric.getTimestamp() >= from && metric.getTimestamp() < to)
            .toList();
    return mapMetricIntoMetricIterator(storage);
  }

  private MetricIterator mapMetricIntoMetricIterator(Storage storage) {
    storage.parallelStream()
            .filter(metricName -> storage.contains(metricName.getName()))
            .forEach(metric -> {
              iteratorMetric.setName(metric.getName());
              iteratorMetric.setFrom(metric.getTimestamp());
              iteratorMetric.setTo(metric.getTimestamp());
            });
    return iteratorMetric;
  }
}
