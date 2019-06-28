package pl.coderslab.driver.controller;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.model.Advice;
import pl.coderslab.driver.model.Category;
import pl.coderslab.driver.service.AdviceService;
import pl.coderslab.driver.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {

    @Autowired
    AdviceService adviceService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advice> getAllAdvices(){
        List<Advice> advices = adviceService.getAllAdvices();
        return advices;

    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Advice showAdvice(@PathVariable Long id){

        return adviceService.findAdviceById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeAdvice(@PathVariable Long id){
        adviceService.removeAdvice(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAdvice(@RequestBody Advice advice){
        for (Category category : advice.getCategories()) {

            categoryService.saveCategory(category);

        }

        adviceService.saveAdvice(advice);

                   }

    @RequestMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateAdvice(@RequestBody Advice advice,@PathVariable Long id){
        Advice updatedAdvice = adviceService.findAdviceById(id);
        updatedAdvice.setCategories(advice.getCategories());
        updatedAdvice.setContent(advice.getContent());
        updatedAdvice.setName(advice.getName());
        updatedAdvice.setTests(advice.getTests());
        adviceService.saveAdvice(updatedAdvice);
    }
}
