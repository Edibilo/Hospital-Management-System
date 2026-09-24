package iki.qom.service;

import iki.qom.dto.RoleDto;

import java.util.List;

public interface RoleService {
    String createRole(RoleDto roleDto);
    List<RoleDto> getAllRoles();
    RoleDto findRoleById(Long roleId);
    void deleteRole(Long roleId);
}
