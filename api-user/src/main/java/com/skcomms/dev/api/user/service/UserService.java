package com.skcomms.dev.api.user.service;

import com.skcomms.dev.api.user.model.UserDto;

import java.util.List;

public interface UserService {

    UserDto findOne(String id);
    List<UserDto> find();
}
