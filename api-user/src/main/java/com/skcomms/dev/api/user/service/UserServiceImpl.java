package com.skcomms.dev.api.user.service;

import com.skcomms.dev.api.user.model.User;
import com.skcomms.dev.api.user.model.UserDto;
import com.skcomms.dev.api.user.model.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository repository)
    {
        this.userRepository=repository;
    }


    @Override
    public UserDto findOne(String id) {
        return UserMapper.instance.userToUserDto(userRepository.findOne(id));
    }

    @Override
    public List<UserDto> find() {
        return UserMapper.instance.usersToUserDtos(userRepository.findAll());
    }
}
