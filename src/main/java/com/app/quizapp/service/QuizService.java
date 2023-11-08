package com.app.quizapp.service;

import java.util.List;

import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.dto.QuizDTO;
import com.app.quizapp.model.QuestionWrapper;

public interface QuizService {
    String createQuiz(QuestionDTO questionDTO);

    List<QuestionWrapper> getQuiz(QuizDTO dto);

    Integer calculateResult(QuizDTO dto);
}
