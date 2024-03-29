package io.murad.exam.portal.service;

import io.murad.exam.portal.model.Quiz;

import java.util.Set;

public interface QuizService {
    Quiz getQuiz(Long id);

    Quiz saveQuiz(Quiz quiz);

    Quiz updateQuiz(Quiz quiz, Long id);

    Set<Quiz> getQuizes();

    void deleteQuiz(Long id);
}
