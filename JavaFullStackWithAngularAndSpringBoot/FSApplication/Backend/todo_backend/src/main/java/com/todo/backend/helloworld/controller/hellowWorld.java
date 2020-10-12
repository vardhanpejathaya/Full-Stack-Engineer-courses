package com.todo.backend.helloworld.controller;


import com.todo.backend.helloworld.bean.HelloWorld;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class hellowWorld {

    @GetMapping(path = "hello-world")
    public String helloWorld() {
        return "Hello vardhan!!";
    }

    @GetMapping(path = "hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello. Message is from backend.");
        //throw new RuntimeException("Some error has happenned!!! Please contact support team.");
    }

    @GetMapping(path = "hello-world-bean/path-variable/{name}")
    public HelloWorld helloWorldpathVariable(@PathVariable String name) {
        return new HelloWorld(String.format("Hello %s", name));
    }
}
