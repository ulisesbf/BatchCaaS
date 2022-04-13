package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.lettuce.core.*;
import io.lettuce.core.api.*;
import io.lettuce.core.api.sync.*;



@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    String home() {
      	 RedisClient redisClient = RedisClient.create(RedisURI.create("127.0.0.1:", 6379));
      	StatefulRedisConnection<String, String> connection = redisClient.connect();
      	RedisCommands<String, String> syncCommands = connection.sync();

      	syncCommands.set("key", "Hello, Redis!");

      	connection.close();
      	redisClient.shutdown();
    	
    	
    	
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}