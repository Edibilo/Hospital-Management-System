package iki.qom.service;

import iki.qom.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto findDepartmentById(Long departmentId);
    void deleteDepartment(Long departmentId);
}
