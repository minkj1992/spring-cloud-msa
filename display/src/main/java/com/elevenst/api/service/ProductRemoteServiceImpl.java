package com.elevenst.api.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductRemoteServiceImpl implements ProductRemoteService {

    public static final String URL = "http://localhost:8082/products/";
    private final RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getProductInfoFallback")
    public String getProductInfo(String productId) {
        return this.restTemplate.getForObject(URL + productId, String.class);
    }

    public String getProductInfoFallback(String productId, Throwable t) {
        System.out.println("t = " + t);
        return "[This Product is sold out]";
    }
}
