package com.metric.app.controller;

import com.metric.app.model.Metric;
import com.metric.app.serviceImpl.MetricServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MetricController {

  @Autowired
  private MetricServiceImpl service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void insert(@RequestBody Metric metric) throws Exception {
    service.insert(metric);
  }
  @DeleteMapping("/{name}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remove(@PathVariable String name) throws Exception {
    service.removeAll(name);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public void query(@RequestParam("name") String name,
                    @RequestParam(value = "from", required = false) long from,
                    @RequestParam(value = "to", required = false) long to) throws Exception {
    service.query(name,from,to);
  }
}
