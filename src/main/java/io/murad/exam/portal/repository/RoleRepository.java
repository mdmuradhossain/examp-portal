package io.murad.exam.portal.repository;

import io.murad.exam.portal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
