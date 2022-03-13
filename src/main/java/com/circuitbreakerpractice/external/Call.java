package com.circuitbreakerpractice.external;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Random;

@Component
public class Call {
    private WebClient webClient;

    Call(){
        webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
    }

    public Mono<String> getApiHello(String name){
        return webClient.get()
                .uri("/hello/"+name)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiIllegal(){
        final Random random = new Random();
        if(random.nextBoolean())
            throw new IllegalArgumentException("IllegalArgumentException 발생");

        return webClient.get()
                .uri("/illegal")
                .retrieve()
                .bodyToMono(String.class);
    }
}
