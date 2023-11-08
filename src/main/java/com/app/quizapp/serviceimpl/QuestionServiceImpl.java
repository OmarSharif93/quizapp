package com.app.quizapp.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.quizapp.dao.QuestionDao;
import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.model.Question;
import com.app.quizapp.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Override
    public List<Question> getAllQuestions() {

        return questionDao.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(QuestionDTO questionDTO) {
        String category = questionDTO.getCategory();

        return questionDao.findByCategory(category);
    }

    @Override
    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionDao.deleteById(id);
    }

}
