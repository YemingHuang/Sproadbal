package com.aft.thing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ThingController {

    @Autowired
    private ThingService service;

    @RequestMapping(value = "/thing/add", method = RequestMethod.POST)
    public void thingAdd(@ModelAttribute Thing thing) {
        service.add(thing);
    }

    @RequestMapping(value = "/thing", method = RequestMethod.GET)
    public List<Thing> getAll() {
        return service.getThings();
    }

}
