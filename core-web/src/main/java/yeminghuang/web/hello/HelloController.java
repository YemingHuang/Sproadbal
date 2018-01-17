package yeminghuang.web.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Gilgamesh") String name) {
        String greeting = this.restTemplate.getForObject("http://feature-hello-sayer/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

}
