package com.question.controller;


import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> getQuestions(){
        return questionService.getQuestonList();
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
       return questionService.getQuestionsOfQuiz(quizId);
    }


    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId){
        return questionService.getQuestionById(questionId);
    }


}
