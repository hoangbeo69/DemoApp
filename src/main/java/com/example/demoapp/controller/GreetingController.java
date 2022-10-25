package com.example.demoapp.controller;

import com.example.demoapp.model.Greeting;
import com.example.demoapp.producer.KafkaProducer;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
  //Rest
  //  @PostMapping
  //  public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting) {
  //    return ResponseEntity.ok(greeting);
  //  }
  @Autowired Supplier<Mono<Greeting>> messageProducer;

  @PostMapping()
  private Mono<Greeting> saveGreeting(@RequestBody Greeting greeting) {
    messageProducer.get();
    return Mono.just(greeting);
  }

  @GetMapping("/{id}")
  private Mono<Greeting> getGreeting(@PathVariable String id) {
    return Mono.just(new Greeting(1L,"Hello"));
  }
}