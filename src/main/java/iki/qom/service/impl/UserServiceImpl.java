package iki.qom.service.impl;

import iki.qom.dto.UserDto;
import iki.qom.entity.User;
import iki.qom.mapper.UserMapper;
import iki.qom.repository.UserRepository;
import iki.qom.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto profile() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User user=userRepository.findUserByEmail(email).orElseThrow(
               () -> new RuntimeException("User Not Found !")
        );
        UserDto userDto=new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setGenderStatus(user.getGenderStatus());
        userDto.setEmail(user.getEmail());
        userDto.setAccountStatus(user.getAccountStatus());
        userDto.setRoleName(user.getRole().getName());
        return userDto;
    }

    @Override
    public UserDto findUserById() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        User user=userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        User user1=userRepository.findById(user.getId()).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        return UserMapper.mapToUserDto(user1);
    }

    @Override
    public List<UserDto> getAllDoctors() {
        List<User> users=userRepository.getAllDoctor();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getByUserId(Long userId) {
       User user=userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
       return UserMapper.mapToUserDto(user);
    }

    @Override
    public User loggedInUser() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email= authentication.getName();
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
    }
}
