package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.model.Quiz;
import io.murad.exam.portal.repository.QuizRepository;
import io.murad.exam.portal.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;


    @Override
    public Optional<Quiz> getQuiz(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz, Long id) {
        Quiz quiz1 = quizRepository.findById(quiz.getId()).get();

        return quizRepository.save(quiz1);
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
