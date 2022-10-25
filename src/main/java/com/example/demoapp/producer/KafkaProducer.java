package com.example.demoapp.producer;


import com.example.demoapp.model.Greeting;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class KafkaProducer {

  @Bean
  public Supplier<Mono<Greeting>> messageProducer() {
    return ()->Mono.just(new Greeting(1L, "Hello1"));
  }


}
