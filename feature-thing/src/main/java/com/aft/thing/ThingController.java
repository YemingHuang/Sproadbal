package com.aft.thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ThingController {

    @Autowired
    private ThingService service;

    @RequestMapping(value = "/thing/add", method = RequestMethod.POST)
    @ResponseBody
    public String thingAdd(@RequestBody Thing thing) {
        service.add(thing);
        return "success";
    }

    @RequestMapping(value = "/thing", method = RequestMethod.GET)
    @ResponseBody
    public List<Thing> getAll() {
        return service.getThings();
    }

}
