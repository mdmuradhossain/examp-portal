package io.murad.exam.portal.repository;

import io.murad.exam.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
