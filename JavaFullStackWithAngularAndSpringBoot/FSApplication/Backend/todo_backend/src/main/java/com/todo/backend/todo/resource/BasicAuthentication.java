package com.todo.backend.todo.resource;


import com.todo.backend.helloworld.bean.HelloWorld;
import com.todo.backend.todo.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthentication {


    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        return new AuthenticationBean("You are authenticated!");
        //throw new RuntimeException("Some error has happenned!!! Please contact support team.");
    }
}
