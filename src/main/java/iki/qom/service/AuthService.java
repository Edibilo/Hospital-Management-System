package iki.qom.service;

import iki.qom.dto.UserDto;

public interface AuthService {
    UserDto register(UserDto userDto);
}
