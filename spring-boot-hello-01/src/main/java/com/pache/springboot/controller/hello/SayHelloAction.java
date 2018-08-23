package com.pache.springboot.controller.hello;

import com.pache.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloAction {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/say-hello")
    public String sayHello(){
        return "Hello! Spring boot!";
    }

}
