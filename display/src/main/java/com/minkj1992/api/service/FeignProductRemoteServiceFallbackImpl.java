package com.minkj1992.api.service;

import org.springframework.stereotype.Component;

@Component
public class FeignProductRemoteServiceFallbackImpl implements FeignProductRemoteService{
    @Override
    public String getProductInfo(String productId) {
        return "[This Product is sold out]";
    }
}
