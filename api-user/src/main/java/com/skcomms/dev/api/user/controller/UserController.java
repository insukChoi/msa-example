package com.skcomms.dev.api.user.controller;

import com.skcomms.dev.api.user.model.UserDto;
import com.skcomms.dev.api.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/user", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> findAllUsers()
    {
        return ResponseEntity.ok(userService.find());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable String id)
    {
        return ResponseEntity.ok(userService.findOne(id));
    }

}
