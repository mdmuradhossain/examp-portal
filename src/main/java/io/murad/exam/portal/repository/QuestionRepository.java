package io.murad.exam.portal.repository;

import io.murad.exam.portal.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
