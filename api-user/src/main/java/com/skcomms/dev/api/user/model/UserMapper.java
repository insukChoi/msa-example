package com.skcomms.dev.api.user.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface UserMapper {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);
    List<UserDto> usersToUserDtos(List<User> users);
}
