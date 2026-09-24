package iki.qom.service.impl;

import iki.qom.mapper.RoleMapper;
import iki.qom.dto.RoleDto;
import iki.qom.entity.Role;
import iki.qom.repository.RoleRepository;
import iki.qom.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public String createRole(RoleDto roleDto) {
        Role role;
        if(roleDto.getId()==null){
            if(roleRepository.existsByName(roleDto.getName())){
                throw new RuntimeException("Role Name Already Added !");
            }
            role=new Role();
        }else {
            role=roleRepository.findById(roleDto.getId()).orElseThrow(
                    () -> new RuntimeException("Role Not Found !")
            );
        }

        assert role != null;
        role.setName(roleDto.getName());
        roleRepository.save(role);
        return "Role Saved!";
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles=roleRepository.findAll();
        return roles.stream().map(RoleMapper::mapToRoleDto).collect(Collectors.toList());
    }

    @Override
    public RoleDto findRoleById(Long roleId) {
        Role role=roleRepository.findById(roleId).orElseThrow(
                () -> new RuntimeException("Role Not Found !")
        );
        return RoleMapper.mapToRoleDto(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role=roleRepository.findById(roleId).orElseThrow(
                () -> new RuntimeException("Role Not Found !")
        );
        roleRepository.delete(role);
    }
}
