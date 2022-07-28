package com.takush.bank.mappers;

import com.takush.bank.dto.UserDto;
import com.takush.bank.entities.UserAbs;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
   // UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    UserDto toDto(UserAbs user);
    UserAbs fromDto(UserDto userDto);

    List<UserDto> toDtoList(List<UserAbs> userList);
    List<UserAbs> fromDtoList(List<UserDto> userDtoList);


}
