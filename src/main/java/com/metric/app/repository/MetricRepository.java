package com.metric.app.repository;

import com.metric.app.model.IteratorMetric;
import com.metric.app.model.Metric;
import com.metric.app.model.Storage;
import com.metric.app.service.MetricIterator;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MetricRepository implements MetricStore {

private static final Logger log = LogManager.getLogger(MetricRepository.class);
  @Autowired
  private Storage storage;


  @Override
  public void insert(Metric metric) throws Exception {
    log.info("starting insert: ");
    storage.add(metric);
    log.info("Save metric: {}, {}", metric.getName(), metric.getTimestamp());
  }

  @Override
  public void removeAll(String name) {
    log.info("starting removeAll: ");
    var elements = storage.parallelStream()
            .filter(element -> element.getName().equals(name))
            .toList();
    storage.removeAll(elements);
    log.info("Removed metric: {}", name);
  }
  @Override
  public MetricIterator query(String name, long from, long to) {
    log.info("starting query: ");
    var iteratorMetric = new IteratorMetric();
    try {
      var itera = storage.parallelStream().iterator();
      while (itera.hasNext()) {
        var metric =itera.next();
        if (metric.getName().equals(name)){
          iteratorMetric.setName(metric.getName());
          if (metric.getTimestamp() >= from && metric.getTimestamp() < to)
            iteratorMetric.setFrom(metric.getTimestamp());
            iteratorMetric.setTo(metric.getTimestamp());
          iteratorMetric.setFrom(metric.getTimestamp());
        }
      }
      log.info("finished query: {}, {}, {}, {}", storage.size(), iteratorMetric.getName(), iteratorMetric.getFrom(), iteratorMetric.getTo());

    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
    return iteratorMetric;
  }
}
