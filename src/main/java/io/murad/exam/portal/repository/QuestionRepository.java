package io.murad.exam.portal.repository;

import io.murad.exam.portal.model.Question;
import io.murad.exam.portal.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
