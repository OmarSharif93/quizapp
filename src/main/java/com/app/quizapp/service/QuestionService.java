package com.app.quizapp.service;

import java.util.List;

import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.model.Question;

public interface QuestionService {
    List<Question> getAllQuestions();

    List<Question> getQuestionsByCategory(QuestionDTO questionDTO);

    String addQuestion(Question question);

    void deleteQuestion(Integer id);
}
