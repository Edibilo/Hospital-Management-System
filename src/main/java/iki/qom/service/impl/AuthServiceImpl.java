package iki.qom.service.impl;

import iki.qom.dto.UserDto;
import iki.qom.entity.Department;
import iki.qom.entity.Role;
import iki.qom.entity.User;
import iki.qom.mapper.UserMapper;
import iki.qom.repository.DepartmentRepository;
import iki.qom.repository.RoleRepository;
import iki.qom.repository.UserRepository;
import iki.qom.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public AuthServiceImpl(RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                           UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public UserDto register(UserDto userDto) {

        Role role;
        User user;
        Department department;
        if (userDto.getId() == null) {
            if (userRepository.existsByEmail(userDto.getEmail())) {
                throw new RuntimeException("Email Already Used !");
            }
            role = roleRepository.findByName("ROLE_PATIENT");
            if (role == null) {
                throw new RuntimeException("Role Not Found !");
            }
            user = new User();
            department = null;
        } else {
            user = userRepository.findById(userDto.getId()).orElseThrow(
                    () -> new RuntimeException("User Not Found !")
            );
            role = roleRepository.findById(userDto.getRoleId()).orElseThrow(
                    () -> new RuntimeException("Role Id Not Found !")
            );
            if(Objects.equals(user.getRole().getName(), "ROLE_PATIENT") ||
                    Objects.equals(user.getRole().getName(), "ROLE_ADMIN")){
                department=null;
            }else{
                department=departmentRepository.findById(userDto.getDepartmentId()).orElseThrow(
                        () -> new RuntimeException("Department Not Found !")
                );
            }
        }

        user.setGenderStatus(userDto.getGenderStatus());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAccountStatus(userDto.getAccountStatus());
        user.setRole(role);
        user.setDepartment(department);
        userRepository.save(user);
        return UserMapper.mapToUserDto(user);
    }
}
