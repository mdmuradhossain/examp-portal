package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.model.Question;
import io.murad.exam.portal.repository.QuestionRepository;
import io.murad.exam.portal.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Override
    public Optional<Question> getQuestion(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question saveQuiz(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuiz(Question question, Long id) {
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
}
