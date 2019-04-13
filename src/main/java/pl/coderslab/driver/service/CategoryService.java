package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.driver.model.Category;
import pl.coderslab.driver.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class CategoryService {

    @Autowired
   private CategoryRepository categoryRepository;


    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }
}
