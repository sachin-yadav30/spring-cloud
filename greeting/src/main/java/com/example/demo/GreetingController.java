package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GreetingController {
     public static final Logger LOG=Logger.getLogger(GreetingController.class.getName());

     @Autowired
     private GreetingProperties greetingProperties;





    @RequestMapping("/{languageCode}")
    public String getGreeting(@PathVariable String languageCode){
        LOG.info("Language Code: " + languageCode);
        LOG.info("Greeting: " + greetingProperties.getGreetings().get(languageCode.toUpperCase()));
        return greetingProperties.getGreetings().getOrDefault(languageCode.toUpperCase(), greetingProperties.getGreeting());
    }

    @RequestMapping("/")
    public String getGreeting(){
        LOG.info("Greeting: " + greetingProperties.getGreeting());
        return greetingProperties.getGreeting();
    }
}
