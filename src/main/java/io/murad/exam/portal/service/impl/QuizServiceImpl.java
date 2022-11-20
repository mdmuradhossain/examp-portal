package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.exception.QuizNotFoundException;
import io.murad.exam.portal.model.Quiz;
import io.murad.exam.portal.repository.QuizRepository;
import io.murad.exam.portal.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;


    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new QuizNotFoundException("Quiz not found"));
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz, Long id) {
        Quiz updateQuiz = quizRepository.findById(quiz.getId()).get();
        updateQuiz.setCategory(quiz.getCategory());
        updateQuiz.setDescription(quiz.getDescription());
        updateQuiz.setMaxMarks(quiz.getMaxMarks());
        return quizRepository.save(updateQuiz);
    }

    @Override
    public Set<Quiz> getQuizes() {
        return new HashSet<>(quizRepository.findAll());
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
