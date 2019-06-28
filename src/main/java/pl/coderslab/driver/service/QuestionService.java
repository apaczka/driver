package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.driver.model.Question;
import pl.coderslab.driver.model.Test;
import pl.coderslab.driver.repository.QuestionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> showAllQuestions(){
        List<Question> list = questionRepository.findAll();
        return list;
    }

    public Optional<Question> findById(Long id){
        return questionRepository.findById(id);
    }

    public List<Question> showAllQuestionsInTest (List <Test> tests){
        return questionRepository.findAllByTests(tests);

    }

      public void removeQuestion(Long id){
        questionRepository.deleteById(id);
    }

}
