package iki.qom.service.impl;

import iki.qom.dto.DashboardDto;
import iki.qom.repository.DepartmentRepository;
import iki.qom.service.AdminDashboardService;
import org.springframework.stereotype.Service;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {

    private final DepartmentRepository departmentRepository;

    public AdminDashboardServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DashboardDto getAdminDashboard() {
        DashboardDto dashboardDto=new DashboardDto();
        dashboardDto.setTotalDepartment(departmentRepository.totalDepartment());
        return dashboardDto;
    }
}
