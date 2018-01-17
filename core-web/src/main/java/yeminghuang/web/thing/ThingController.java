package yeminghuang.web.thing;

import yeminghuang.thing.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
public class ThingController {

    public static final String HTTP_FEATURE_THING_THING = "http://feature-thing";
    @Autowired

    RestTemplate restTemplate;

    @RequestMapping("/thing")
    public String thingView(Map<String, Object> model) {

        List<Thing> things = this.restTemplate.getForObject(HTTP_FEATURE_THING_THING + "/thing", List.class);
        model.put("things", things);
        model.put("newThing", new Thing());
        return "thing";
    }

    @RequestMapping(value = "/thing/add", method = RequestMethod.POST)
    public String thingAdd(@ModelAttribute Thing thing) {
        restTemplate.postForEntity(HTTP_FEATURE_THING_THING + "/thing/add", thing, String.class);
        return "redirect:/thing";
    }

}
