package io.murad.exam.portal.service;

import io.murad.exam.portal.model.Question;

import java.util.Optional;
import java.util.Set;

public interface QuestionService {

    Optional<Question> getQuestion(Long id);
    Question saveQuiz(Question question);
    Question updateQuiz(Question question, Long id);
    Set<Question> getQuestions();
    void deleteQuestion(Long id);
}
