package com.circuitbreakerpractice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExternalApiController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        if("fail".equals(name))
            throw new RuntimeException();

        return "hello "+name;
    }

    @GetMapping("/illegal")
    public String illegal(){
        return String.valueOf(System.currentTimeMillis());
    }
}
