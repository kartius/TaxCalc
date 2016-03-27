package com.taxcalc.controller;

import com.taxcalc.dto.Tax;
import com.taxcalc.sericeImpl.TaxServiceImpl;
import com.taxcalc.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by KART on 10.03.2016.
 */

@RestController
@RequestMapping("")
public class MainController {

    @Autowired
    private TaxService taxService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getHello() throws Exception{
        System.out.println("before call");
        Tax tax = new Tax();
        tax.setDateTime(new Date());
        taxService.addTax(tax);
        System.out.println("after call");
        return "I can work";
    }
}
