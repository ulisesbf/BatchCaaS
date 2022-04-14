package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.lettuce.core.*;
import io.lettuce.core.api.*;
import io.lettuce.core.api.sync.*;
import redis.clients.jedis.Jedis;



@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoApplication {

    @RequestMapping("/")
    String home() {
  	  Jedis jedis = new Jedis("10.217.5.158", 6379);
		    jedis.auth("Armani16");
		    System.out.println("Connected to Redis");
		    jedis.set("foo", "bar");
		    String value = jedis.get("foo");
		    System.out.println(value);
  
      return "Hello World! "+value;
  }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}