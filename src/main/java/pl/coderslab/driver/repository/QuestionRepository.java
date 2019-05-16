package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.model.Question;

import java.time.LocalDate;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    public Question findByTestIdAndByAndId(Long testId, Long id);

    public List<Question> findAllByTestId(Long testId);
}
