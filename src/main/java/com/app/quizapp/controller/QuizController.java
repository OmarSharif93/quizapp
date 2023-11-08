package com.app.quizapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.dto.QuizDTO;
import com.app.quizapp.model.QuestionWrapper;
import com.app.quizapp.serviceimpl.QuizServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizServiceImpl quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ok(quizService.createQuiz(questionDTO));
    }

    @GetMapping("getQuiz")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@RequestBody QuizDTO dto) {
        return ResponseEntity.ok(quizService.getQuiz(dto));
    }

    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody QuizDTO dto) {

        return ResponseEntity.ok(quizService.calculateResult(dto));
    }
}
