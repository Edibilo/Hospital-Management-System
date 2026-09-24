package iki.qom.service;

import iki.qom.dto.UserDto;
import iki.qom.entity.User;

import java.util.List;

public interface UserService {
    UserDto profile();
    UserDto findUserById();
    List<UserDto> getAllDoctors();
    List<UserDto> getAllUsers();
    UserDto getByUserId(Long userId);
    User loggedInUser();
}
