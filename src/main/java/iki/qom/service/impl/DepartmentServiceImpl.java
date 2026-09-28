package iki.qom.service.impl;

import iki.qom.dto.DepartmentDto;
import iki.qom.entity.Department;
import iki.qom.mapper.DepartmentMapper;
import iki.qom.repository.DepartmentRepository;
import iki.qom.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments=departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findDepartmentById(Long departmentId) {
        Department department=departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("Department Not Found !")
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department=departmentRepository.findById(departmentId).orElseThrow(
                () -> new RuntimeException("Department Not Found !")
        );
        departmentRepository.delete(department);
    }

}
