package com.metric.app.serviceImpl;

import com.metric.app.model.Metric;
import com.metric.app.repository.MetricRepository;
import com.metric.app.service.MetricIterator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MetricServiceImpl {

  @Autowired
  private MetricRepository repository;

  public void insert(Metric metric) throws Exception {
    this.repository.insert(metric);
  }

  public void removeAll(String name){
    this.repository.removeAll(name);
  }

  public MetricIterator query(String name, long from, long to) {
    return this.repository.query(name, from, to);
  }
}
