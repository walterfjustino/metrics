package com.metric.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		ExecutorService executor = Executors.newCachedThreadPool();
//		var service = new MetricServiceImpl(new MetricRepository(new Storage(), new IteratorMetric()));

//		var metric1 = new Metric("data-hoje", Instant.now().toEpochMilli());
//		executor.awaitTermination(3, TimeUnit.SECONDS);
//		var metric2 = new Metric("data-amanha", Instant.now().toEpochMilli());
//		executor.awaitTermination(5, TimeUnit.SECONDS);
//		var metric3 = new Metric("data-depois-de-amanha", Instant.now().toEpochMilli());
//		executor.awaitTermination(5, TimeUnit.SECONDS);
//		var metric4 = new Metric("anti-penultimo", Instant.now().toEpochMilli());
//		executor.awaitTermination(5, TimeUnit.SECONDS);
//		var metric5 = new Metric("penultimo", Instant.now().toEpochMilli());
//		executor.awaitTermination(5, TimeUnit.SECONDS);
//		var metric6 = new Metric("por-ultimo", Instant.now().toEpochMilli());

//		try {
//			LOG.info("start save the metrics: ");
//			LOG.info("save the metrics: ", metric1);
//			service.insert(metric1);
//			LOG.info("save the metrics: ", metric2);
//			service.insert(metric2);
//			LOG.info("save the metrics: ", metric3);
//			service.insert(metric3);
//			LOG.info("save the metrics: ", metric4);
//			service.insert(metric4);
//			LOG.info("save the metrics: ", metric5);
//			service.insert(metric5);
//			LOG.info("save the metrics: ", metric6);
//			service.insert(metric6);
//			LOG.info("finished save the metrics: ", metric6);
//
//
//			LOG.info("starting query: ", metric3);
//			service.query(metric3.getName(), metric3.getTimestamp(), new Timestamp(System.currentTimeMillis()).getTime());
//			LOG.info("finished query: ", metric3);
//
//			LOG.info("executing removeAll: ", metric3);
//			service.removeAll(metric3.getName());
//			LOG.info("finished removeAll: ", metric3);
//
//			executor.shutdown();
//		} catch (Exception e) {
//			throw new Exception(e.getCause());
//		} finally {
//			executor.shutdownNow();
//		}
	}
}
