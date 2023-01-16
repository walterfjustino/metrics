package com.metric.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IteratorMetric implements com.metric.app.service.MetricIterator {

  @Autowired
  private Storage storageIterator;

  private String name;
  private long from;
  private long to;

  @Override
  public boolean moveNext() {
    var existsNextElement = storageIterator.parallelStream().iterator();
    if (!existsNextElement.hasNext()) {
      return false;
    } else {
      existsNextElement.next();
      return true;
    }
  }

  @Override
  public Metric current() {
    return storageIterator.parallelStream()
            .max(Comparator.comparingLong(Metric::getTimestamp))
            .orElse(storageIterator.getLast());
  }

  @Override
  public void remove() {
    storageIterator.remove();
  }

  @Override
  public void close() throws Exception {

  }
}
