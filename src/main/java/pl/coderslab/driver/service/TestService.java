package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.driver.model.Test;
import pl.coderslab.driver.repository.TestRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TestService {


    @Autowired
    private TestRepository testRepository;

    public Test findTestById(Long id){
      return testRepository.getOne(id);
    }

    public List<Test> showAllTests(){
        List<Test> list = testRepository.findAll();
        return list;
    }

    public void saveTest(Test test){
        testRepository.save(test);
    }
    public void removeTest(Long id){
        testRepository.deleteById(id);
    }

}
