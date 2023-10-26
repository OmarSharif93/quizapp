package com.app.quizapp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class QuestionDTO {

    private String category;
    private Integer numberOfQuestions;
    private String title;
}
