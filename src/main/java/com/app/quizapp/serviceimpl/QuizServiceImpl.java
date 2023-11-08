package com.app.quizapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.quizapp.dao.QuestionDao;
import com.app.quizapp.dao.QuizDao;
import com.app.quizapp.dto.QuestionDTO;
import com.app.quizapp.dto.QuizDTO;
import com.app.quizapp.model.Question;
import com.app.quizapp.model.QuestionWrapper;
import com.app.quizapp.model.Quiz;
import com.app.quizapp.model.Response;
import com.app.quizapp.service.QuizService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuestionDao questionDao;
    private final QuizDao quizDao;

    @Override
    public String createQuiz(QuestionDTO questionDTO) {
        String category = questionDTO.getCategory();
        int numberOfQuestions = questionDTO.getNumberOfQuestions();
        String title = questionDTO.getTitle();

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numberOfQuestions);

        Quiz quizEntity = new Quiz();
        quizEntity.setTitle(title);
        quizEntity.setQuestions(questions);
        quizDao.save(quizEntity);

        return "success";
    }

    @Override
    public List<QuestionWrapper> getQuiz(QuizDTO dto) {
        int id = dto.getId();
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
                    q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return questionForUser;
    }

    @Override
    public Integer calculateResult(QuizDTO dto) {
        int id = dto.getId();
        List<Response> responses = dto.getResponse();

        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer())) {
                right++;
            }
            i++;
        }
        return right;
    }
}
