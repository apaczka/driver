package pl.coderslab.driver.controller;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.model.Advice;
import pl.coderslab.driver.service.AdviceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {

    @Autowired
    AdviceService adviceService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advice> getAllAdvices(){
        List<Advice> advices= new ArrayList<>();
        advices = adviceService.getAllAdvices();
        return advices;

    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional<Advice> showAdvice(@PathVariable Long id){
        return adviceService.findById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeAdvice(@PathVariable Long id){
        adviceService.removeAdvice(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAdvice(@RequestBody Advice advice){
                adviceService.saveAdvice(advice);

    }

    @RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public void updateAdvice(@RequestBody Advice advice){
        adviceService.saveAdvice(advice);
    }
}
