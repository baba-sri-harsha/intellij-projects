package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {
    //this is a rest api
    // in the controller japplication name is follwed by url
    // but in rest controller url is called since it is jar file

    //http://localhost://greet
    @RequestMapping("/greet")
    public String greetMessage(){
        String message ="have a great day";
        //rest api returns data
        return message;
    }

    //http://localhost://show
//    @RequestMapping(name="show",method= RequestMethod.GET)
    @GetMapping("/show")
    public List<String>showCourses(){
        // api return list
        return Arrays.asList("java", "spring","node");
    }

}
