package iki.qom.repository;

import iki.qom.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query("Select count(*) from Department ")
    int totalDepartment();

}
