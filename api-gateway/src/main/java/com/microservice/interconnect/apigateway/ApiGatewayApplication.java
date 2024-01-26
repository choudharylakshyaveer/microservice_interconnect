package com.microservice.interconnect.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);

    }
    //http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR
}