package com.example.demoapp.producer;

import java.util.function.Consumer;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumer {
  @Bean
  public Consumer<KStream<String, Long>> messageConsumer(){
    return stream -> stream.foreach((key, value) -> System.out.println("messageConsumer : " + value));
  }
}
