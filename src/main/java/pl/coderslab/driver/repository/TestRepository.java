package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.model.Test;

public interface TestRepository extends JpaRepository<Test,Long> {
}
