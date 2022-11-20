package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.exception.QuestionNotFoundException;
import io.murad.exam.portal.model.Question;
import io.murad.exam.portal.model.Quiz;
import io.murad.exam.portal.repository.QuestionRepository;
import io.murad.exam.portal.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Override
    public Question getQuestion(Long id) throws QuestionNotFoundException {
        return questionRepository.findById(id).orElseThrow(() -> new QuestionNotFoundException("Question Not Found"));
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question, Long id) throws QuestionNotFoundException {
        Question updateQuestion = questionRepository.findById(id).orElseThrow(() ->
                new QuestionNotFoundException("Not found"));
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(questionRepository.findAll());
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return new HashSet<>(questionRepository.findByQuiz(quiz));
    }
}
