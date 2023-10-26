package com.app.quizapp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.quizapp.model.Response;

import lombok.Data;

@Data
@Component
public class QuizDTO {
    private Integer id;
    private List<Response> response;
}
