package com.circuitbreakerpractice.service;

import com.circuitbreakerpractice.external.Call;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CircuitService {
    private final Call call;
    private static final String DEFAULT_NAME = "hgsssss";
    private static final String ILLEGAL_FALLBACK_DEFAULT = "illegalFallback";
    private static final String FALLBACK_DEFAULT = "helloFallback";

    @CircuitBreaker(name = DEFAULT_NAME, fallbackMethod = FALLBACK_DEFAULT)
    public Mono<String> getHello(String name){
        return call.getApiHello(name);
    }

    @CircuitBreaker(name = DEFAULT_NAME, fallbackMethod = ILLEGAL_FALLBACK_DEFAULT)
    @Retry(name = DEFAULT_NAME)
    public Mono<String> getIllegal(){
        log.info("getIllegal start");
        return call.getApiIllegal();
    }

    private Mono<String> illegalFallback(Throwable t){
        log.error("illegalFallback Fallback : "+t.getClass()+" / "+ t.getMessage());
        return Mono.just("[Retry] retry 중 오류");
    }

    private Mono<String> helloFallback(String name, Throwable t){
        log.error("Fallback : "+ t.getMessage());
        return Mono.just("fallback data");
    }
}
