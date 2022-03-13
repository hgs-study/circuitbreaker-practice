package com.circuitbreakerpractice.controller;

import com.circuitbreakerpractice.service.CircuitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CircuitController {
    private final CircuitService circuitService;

    @GetMapping("/hello/{name}")
    public Mono<String> getHelloName(@PathVariable String name){
        return circuitService.getHello(name);
    }

    @GetMapping("/illegal")
    public Mono<String> getIllegal(){
        return circuitService.getIllegal();
    }
}
