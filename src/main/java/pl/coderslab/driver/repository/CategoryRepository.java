package pl.coderslab.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.driver.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
