package com.metric.app.serviceImpl;

import com.metric.app.model.Metric;
import com.metric.app.repository.MetricRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MetricServiceImpl {

  @Autowired
  private MetricRepository repository;

  void insert(Metric metric) throws Exception {
    this.repository.insert(metric);
  }

  void removeAll(String name){
    this.repository.removeAll(name);
  }
}
