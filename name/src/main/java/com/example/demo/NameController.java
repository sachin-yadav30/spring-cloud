package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class NameController {
    private static final Logger LOG = Logger.getLogger(NameController.class.getName());

    @Autowired
    private NameProperties nameProperties;


    @RequestMapping("/")
    public String getName() {
        LOG.info("Name: " + nameProperties.getName());
        return nameProperties.getName();
    }

}
