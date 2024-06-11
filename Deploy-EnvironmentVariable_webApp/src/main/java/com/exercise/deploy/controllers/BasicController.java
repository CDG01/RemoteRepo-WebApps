package com.exercise.deploy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BasicController {

    // MODO 1:
    private final Environment environment;

    @Autowired
    public BasicController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/dev")
    public String getDev() {
        return environment.getProperty("devName");
    }


    // MODO 2:
    @Value("${devName}")
    String devNameVariable;

    @GetMapping("/dev_v2")
    public String getDev_v2() {
        return devNameVariable;
    }

}
