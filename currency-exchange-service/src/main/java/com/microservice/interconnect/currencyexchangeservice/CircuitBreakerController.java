package com.microservice.interconnect.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
    //@CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")
    //@RateLimiter(name = "default", fallbackMethod = "hardCodedResponse") //In specific time period(ex. 10 sec), we want to 1000 calls to the sampleApi
    @Bulkhead(name = "sample-api") //Defines how many concurrent calls are allowed
    public String sampleApi(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        log.info("sample-api call received || "+df.format(new Date()));
        //ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", null, String.class);
        return "Sample API";
        //return forEntity.getBody();
    }

    public String hardCodedResponse(Exception ex){
        return "Fallback Response";
    }
}
