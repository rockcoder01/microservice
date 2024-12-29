package com.quiz.quizServices.services.impl;

import com.quiz.quizServices.entities.Quiz;
import com.quiz.quizServices.repository.QuizRepository;
import com.quiz.quizServices.services.QuestionClient;
import com.quiz.quizServices.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizList = quizRepository.findAll();
        List<Quiz> newQuizList =
                quizList.stream().map(quiz->{
                    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz getById(Long id) {
        Quiz quizItem = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quizItem.setQuestions(questionClient.getQuestionOfQuiz(quizItem.getId()));
        return quizItem;
    }
}
