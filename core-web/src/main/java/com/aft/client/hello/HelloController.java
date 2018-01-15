package com.aft.client.hello;

import com.aft.client.config.LoadBalanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@RibbonClient(name = "feature-hello-sayer", configuration = LoadBalanceConfiguration.class)
public class HelloController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate resttTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Gilgamesh") String name) {
        String greeting = this.resttTemplate.getForObject("http://feature-hello-sayer/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

}
