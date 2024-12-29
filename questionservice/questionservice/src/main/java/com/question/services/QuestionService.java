package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question add(Question question);
    List<Question> getQuestonList();
    Question getQuestionById(Long id);
    List<Question> getQuestionsOfQuiz(Long quizId);
}
