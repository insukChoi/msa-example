package com.skcomms.dev.api.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.skcomms.dev.api.order.model.Product;
import com.skcomms.dev.api.order.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ProductAdapter {

    private final RestTemplate restTemplate;

    @Autowired
    ProductAdapter(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getProductByIdFallback")
    public Product getProductById(String productId)
    {
        return restTemplate.getForObject("http://API-PRODUCT-DEV/v1/product/"+productId,Product.class);
    }

    @SuppressWarnings("unused")
    public Product getProductByIdFallback(String productId)
    {

        log.debug("hystrix fallback getProductByIdFallback()");
        return Product.builder().id(productId).name("example").price(0).build();
    }


}
