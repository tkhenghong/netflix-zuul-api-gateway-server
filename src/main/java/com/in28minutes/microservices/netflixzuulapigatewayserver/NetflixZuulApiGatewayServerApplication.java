package com.in28minutes.microservices.netflixzuulapigatewayserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

// Enable API Gateway
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
    }

    // This is for the old Version
//    @Bean
//    public AlwaysSampler defaultSampler() {
//        return new AlwaysSampler();
//    }

    // Trace all requests
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
