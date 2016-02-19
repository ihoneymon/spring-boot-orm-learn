package io.honeymon.learn.orm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello world!";  
    }
}
