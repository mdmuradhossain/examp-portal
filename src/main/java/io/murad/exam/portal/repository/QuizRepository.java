package io.murad.exam.portal.repository;

import io.murad.exam.portal.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
