package com.app.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.quizapp.dao.QuestionDao;
import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.model.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {

        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(QuestionDTO questionDTO) {
        String category = questionDTO.getCategory();

        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public void deleteQuestion(Integer id) {
        questionDao.deleteById(id);
    }

}
