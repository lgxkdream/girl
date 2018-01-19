package io.lgxkdream.girl.controller;

import io.lgxkdream.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girl;

    @GetMapping("/hello")
    public String say(){
        return "hello,spring boot! " + girl.getCupSize();
    }

}
