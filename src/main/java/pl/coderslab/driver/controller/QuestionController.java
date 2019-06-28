package pl.coderslab.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.model.Question;
import pl.coderslab.driver.model.Test;
import pl.coderslab.driver.service.QuestionService;
import pl.coderslab.driver.service.TestService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> showAllQuestions() {
        return questionService.showAllQuestions();
    }

    @RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> findQuestion(@PathVariable Long id) {
        return questionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

@RequestMapping(path="test/{testId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Question> showAllQuestionsInTest(@PathVariable Long testId){
        Test test = testService.findTestById(testId);
        List <Test> tests = new ArrayList<>();
        tests.add(test);
        return questionService.showAllQuestionsInTest(tests);

}


}
