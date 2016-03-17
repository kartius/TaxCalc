package com.taxcalc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KART on 10.03.2016.
 */

@RestController
@RequestMapping("")
public class MainController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getHello(){
        return "I can work";
    }
}
