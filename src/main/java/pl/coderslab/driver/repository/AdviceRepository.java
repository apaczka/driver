package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.model.Advice;

public interface AdviceRepository extends JpaRepository<Advice,Long> {


}
