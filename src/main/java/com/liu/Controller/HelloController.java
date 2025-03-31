package com.liu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Environment env;

    @Value("${address[0]}")
    private String address;
    @RequestMapping("/address")
    public String getAddress() {
        return address;
    }

    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String personName;

    @Value("${person.age}")
    private int age;

    @RequestMapping("/index")
    public String index() {
        System.out.println(personName);
        System.out.println(age);

        System.out.println(env.getProperty("person.name"));
        System.out.println(env.getProperty("address[2]"));

        return "Hello World" + " " + personName + " " + age;
    }

    @RequestMapping("/name")
    public String name() {
        System.out.println(name);
        return "Hello " + name;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot ";
    }



}
