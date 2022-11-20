package io.murad.exam.portal.controller;


import io.murad.exam.portal.exception.QuestionNotFoundException;
import io.murad.exam.portal.model.Question;
import io.murad.exam.portal.model.Quiz;
import io.murad.exam.portal.service.QuestionService;
import io.murad.exam.portal.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;
    private QuizService quizService;


    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable("questionId") Long id) throws QuestionNotFoundException {
        Question question = questionService.getQuestion(id);
        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Question>> getCategories() {
        return new ResponseEntity<>(questionService.getQuestions(), HttpStatus.OK);
    }

    @PutMapping("/edit/{questionId}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable("questionId") Long id) throws QuestionNotFoundException {
        return new ResponseEntity<>(questionService.updateQuestion(question, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quizId") Long id) {
//        Quiz quiz = new Quiz();
//        quiz.setId(id);
//        Set<Question> questionsOfQuiz = questionService.getQuestionsOfQuiz(quiz);

        Quiz quiz = quizService.getQuiz(id);
        Set<Question> questions = questionService.getQuestionsOfQuiz(quiz);
        List<Question> questionList = new ArrayList<>(questions);
        Collections.shuffle(questionList);
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
}
