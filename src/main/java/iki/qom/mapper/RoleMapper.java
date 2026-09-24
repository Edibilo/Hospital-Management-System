package iki.qom.mapper;

import iki.qom.dto.RoleDto;
import iki.qom.entity.Role;

public class RoleMapper {

    public static RoleDto mapToRoleDto(Role role){
        RoleDto roleDto=new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }

    public static Role mapToRole(RoleDto roleDto){
        Role role=new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }
}
