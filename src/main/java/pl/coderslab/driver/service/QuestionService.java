package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.driver.model.Question;
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

    public Question findByTestAndById(Long testId, Long id){
        return questionRepository.findByTestIdAndByAndId(testId, id);
    }

    public List<Question> findAllByTestId(Long testId){
        List<Question> list = questionRepository.findAllByTestId(testId);
        return list;
    }

    public void removeQuestion(Long id){
        questionRepository.deleteById(id);
    }

}
