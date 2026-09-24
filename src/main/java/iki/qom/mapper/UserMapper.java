package iki.qom.mapper;

import iki.qom.dto.UserDto;
import iki.qom.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setAccountStatus(user.getAccountStatus());
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        userDto.setGenderStatus(user.getGenderStatus());
        userDto.setRoleId(user.getRole().getId());
        userDto.setRoleName(user.getRole().getName());
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user=new User();
        user.setAccountStatus(userDto.getAccountStatus());
        user.setEmail(userDto.getEmail());
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setGenderStatus(userDto.getGenderStatus());
        return user;
    }
}
