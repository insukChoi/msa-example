package com.skcomms.dev.api.user.service;

import com.skcomms.dev.api.common.exception.DataNotFoundException;
import com.skcomms.dev.api.user.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private static List<User> users=new ArrayList<>();

    @PostConstruct
    void init()
    {
        users.add(User.builder().userId("u001").name("sim").email("sim@sk.com").build());
        users.add(User.builder().userId("u002").name("kim").email("kim@sk.com").build());
        users.add(User.builder().userId("u003").name("lee").email("lee@sk.com").build());

    }

    User findOne(String id)
    {
        return users.stream().filter(user -> id.equalsIgnoreCase(user.getUserId())).findFirst().orElseThrow(()->new DataNotFoundException("사용자가 없습니다."));
    }

    List<User> findAll()
    {
        return users;
    }

}
