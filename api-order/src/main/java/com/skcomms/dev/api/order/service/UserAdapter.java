package com.skcomms.dev.api.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.skcomms.dev.api.order.model.OrderDto;
import com.skcomms.dev.api.order.model.Product;
import com.skcomms.dev.api.order.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class UserAdapter {

    private final RestTemplate restTemplate;

    @Autowired
    UserAdapter(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getUserByIdFallback")
    public User getUserById(String userId)
    {
        return restTemplate.getForObject("http://API-USER-DEV/v1/user/"+userId,User.class);
    }

    @SuppressWarnings("unused")
    public User getUserByIdFallback(String userId)
    {
        log.debug("hystrix fallback getUserByIdFallback()");
        return User.builder().userId(userId).email("test@test.com").name("test").build();
    }


}
