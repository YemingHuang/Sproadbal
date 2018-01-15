package com.aft.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ClientApplication {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate resttTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Gilgamesh") String name) {
        String greeting = this.resttTemplate.getForObject("http://localhost:8090/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
