package pl.coderslab.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.model.Test;
import pl.coderslab.driver.service.TestService;


import java.util.List;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Test> showAllTests() {
        List<Test> list = testService.showAllTests();
        return list;

    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Test showTest(@PathVariable Long id) {
        return testService.findTestById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTest(@RequestBody Test test) {
        testService.saveTest(test);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeTest(@PathVariable Long id) {
        testService.removeTest(id);
    }
    @RequestMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateTest(@RequestBody Test test, @PathVariable Long id){
        Test updated = testService.findTestById(id);
        updated.setAdvice(test.getAdvice());
        updated.setTitle(test.getTitle());
        updated.setQuestions(test.getQuestions());
        testService.saveTest(updated);
    }


}
