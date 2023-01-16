//package com.metric.app.serviceImpl;
//
//import com.metric.app.model.Metric;
//import com.metric.app.model.Storage;
//import com.metric.app.repository.MetricRepository;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.time.Instant;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
////@ExtendWith(MockitoExtension.class)
////@DisplayName("AuthorServiceImplTest")
//@SpringBootTest
//public class ServiceImplTests {
//
//  @Autowired
//  private MetricServiceImpl service;
//
//  @Autowired
//  private Storage storage;
//  @MockBean
//  private MetricRepository repository;
//
//  public ServiceImplTests(MetricServiceImpl service, Storage storage, MetricRepository repository) {
//    this.service = service;
//    this.storage = storage;
//    this.repository = repository;
//  }
//
//  @BeforeEach
//  public void setup() throws InterruptedException {
//    ExecutorService executor = Executors.newCachedThreadPool();
//    var metric1 = new Metric("data-hoje", Instant.now().toEpochMilli());
//    executor.awaitTermination(3, TimeUnit.SECONDS);
//    var metric2 = new Metric("data-amanha", Instant.now().toEpochMilli());
//    executor.awaitTermination(5, TimeUnit.SECONDS);
//    var metric3 = new Metric("data-depois-de-amanha", Instant.now().toEpochMilli());
//    executor.awaitTermination(5, TimeUnit.SECONDS);
//    var metric4 = new Metric("anti-penultimo", Instant.now().toEpochMilli());
//    executor.awaitTermination(5, TimeUnit.SECONDS);
//    var metric5 = new Metric("penultimo", Instant.now().toEpochMilli());
//    executor.awaitTermination(5, TimeUnit.SECONDS);
//    var metric6 = new Metric("por-ultimo", Instant.now().toEpochMilli());
//
//    storage.add(metric1);
//    storage.add(metric2);
//    storage.add(metric3);
//    storage.add(metric4);
//    storage.add(metric5);
//    storage.add(metric6);
//  }
//
//
//  @Test
//  public void insert() throws Exception {
//    var mockMetric = new Metric("data-hoje", Instant.now().toEpochMilli());
//    doNothing().when(repository).insert(mockMetric);
//    service.insert(mockMetric);
//    verify(repository, times(1)).insert(mockMetric);
//  }
//}
