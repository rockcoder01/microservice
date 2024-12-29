package com.quiz.quizServices.services;

import com.quiz.quizServices.entities.Quiz;

import java.util.List;

public interface QuizService  {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz getById(Long id);

}
