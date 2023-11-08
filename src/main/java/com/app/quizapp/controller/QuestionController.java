package com.app.quizapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.model.Question;
import com.app.quizapp.serviceimpl.QuestionServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionServiceImpl questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("category")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ok(questionService.getQuestionsByCategory(questionDTO));
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @DeleteMapping("delete/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
    }
}
