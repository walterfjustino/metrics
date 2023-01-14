package com.metric.app.model;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedDeque;

@Component
public class Storage extends ConcurrentLinkedDeque<Metric> {

  private ConcurrentLinkedDeque<Metric> storage = new ConcurrentLinkedDeque<>();
}
