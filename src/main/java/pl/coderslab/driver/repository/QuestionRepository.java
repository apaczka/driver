package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.model.Question;
import pl.coderslab.driver.model.Test;

import java.time.LocalDate;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

 List<Question> findAllByTests (List<Test> tests);


}
