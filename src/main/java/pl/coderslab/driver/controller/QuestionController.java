package pl.coderslab.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.model.Question;
import pl.coderslab.driver.service.QuestionService;

import java.util.List;


@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> showAllQuestions(){
       return questionService.showAllQuestions();
    }

//    @RequestMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public Question findQuestion(@PathVariable Long id){
//
//    }

}
