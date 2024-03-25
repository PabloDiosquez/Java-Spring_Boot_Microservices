package com.example.firstspring;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping(path = "/hello")
    public String sayHello(){
        return "Hello!";
    }

    @PostMapping(path = "/hello")
    public String helloPost(@RequestBody String name){
        return "Hello " + name + "!";
    }
}
