package io.murad.exam.portal.controller;


import io.murad.exam.portal.model.Quiz;
import io.murad.exam.portal.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
@AllArgsConstructor
public class QuizController {

    private QuizService quizService;

    @PostMapping("/add")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.saveQuiz(quiz), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Quiz>> getQuizes() {
        return new ResponseEntity<>(quizService.getQuizes(), HttpStatus.OK);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("quizId") Long id) {
        return new ResponseEntity<Quiz>(quizService.getQuiz(id), HttpStatus.OK);
    }


    @PutMapping("/edit/{quizId}")
    public ResponseEntity<?> editQuiz(@RequestBody Quiz quiz, @PathVariable("quizId") Long id) {
        return new ResponseEntity<>(quizService.updateQuiz(quiz, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<?> removeQuiz(@PathVariable("quizId") Long id) {
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
