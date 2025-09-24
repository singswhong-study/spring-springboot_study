package com.in28minutes.springboot.learnspringspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

//    @Autowired
    private CurrencyServiceConfiguration configuration;

    public CurrencyConfigurationController(CurrencyServiceConfiguration configuration){
        this.configuration = configuration;
    }

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses(){
        return configuration;
    }

}
