package com.app.quizapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.dto.QuizDTO;
import com.app.quizapp.model.QuestionWrapper;
import com.app.quizapp.model.Response;
import com.app.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuestionDTO questionDTO) {
        String category = questionDTO.getCategory();
        int numberOfQuestions = questionDTO.getNumberOfQuestions();
        String title = questionDTO.getTitle();
        return quizService.createQuiz(category, numberOfQuestions, title);
    }

    @GetMapping("getQuiz")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@RequestBody QuizDTO dto) {
        int id = dto.getId();
        return quizService.getQuiz(id);
    }

    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody QuizDTO dto) {
        int id = dto.getId();
        List<Response> response = dto.getResponse();
        return quizService.calculateResult(id, response);
    }
}
