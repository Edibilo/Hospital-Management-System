package iki.qom.repository;

import iki.qom.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByName(String name);
    boolean existsByNameNot(String name);
    Role findByName(String name);
}
