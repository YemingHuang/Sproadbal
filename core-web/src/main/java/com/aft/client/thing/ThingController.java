package com.aft.client.thing;

import com.aft.client.config.LoadBalanceConfiguration;
import com.aft.thing.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@EnableDiscoveryClient
@RibbonClient(name = "feature-thing", configuration = LoadBalanceConfiguration.class)
public class ThingController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTmplt;

    @RequestMapping("/thing")
    public String thingView(Map<String, Object> model) {

        List<Thing> things = this.restTmplt.getForObject("http://feature-thing/thing", List.class);
        model.put("things", things);
        model.put("newThing", new Thing());
        return "thing";
    }

    @RequestMapping(value = "/thing/add", method = RequestMethod.POST)
    public String thingAdd(@ModelAttribute Thing thing) {
        this.restTmplt.postForObject("http://feature-thing/thing", thing, Thing.class);
        return "redirect:/thing";
    }

}
