package io.murad.exam.portal.service;

import io.murad.exam.portal.exception.QuestionNotFoundException;
import io.murad.exam.portal.model.Question;
import io.murad.exam.portal.model.Quiz;

import java.util.Set;

public interface QuestionService {

    Question getQuestion(Long id) throws QuestionNotFoundException;

    Question saveQuestion(Question question);

    Question updateQuestion(Question question, Long id) throws QuestionNotFoundException;

    Set<Question> getQuestions();

    void deleteQuestion(Long id);

    Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
