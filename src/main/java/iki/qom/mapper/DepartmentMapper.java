package iki.qom.mapper;

import iki.qom.dto.DepartmentDto;
import iki.qom.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department=new Department();
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setId(departmentDto.getId());
        return department;
    }

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setId(department.getId());
        return departmentDto;
    }
}
