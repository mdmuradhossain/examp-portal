package io.murad.exam.portal.repository;

import io.murad.exam.portal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
