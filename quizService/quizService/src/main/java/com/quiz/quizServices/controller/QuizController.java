package com.quiz.quizServices.controller;

import com.quiz.quizServices.entities.Quiz;
import com.quiz.quizServices.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }


    @GetMapping
    public List<Quiz> getQuiz(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id){
        return quizService.getById(id);
    }




}
