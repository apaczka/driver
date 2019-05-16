package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.driver.model.Advice;
import pl.coderslab.driver.repository.AdviceRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AdviceService {

    @Autowired
    AdviceRepository adviceRepository;

    public List<Advice> getAllAdvices(){
        List<Advice> advices = adviceRepository.findAll();
        return advices;
    }

    public Advice findAdviceById(Long id){
        return adviceRepository.getOne(id);
    }

    public void removeAdvice(Long id){
        adviceRepository.deleteById(id);
    }

    public void saveAdvice(Advice advice){ adviceRepository.save(advice);}
}
