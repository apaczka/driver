package pl.coderslab.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.driver.model.Category;
import pl.coderslab.driver.repository.CategoryRepository;

import javax.transaction.Transactional;

import java.util.List;


@Component
@Transactional
public class CategoryService {

    @Autowired
   private CategoryRepository categoryRepository;


    public Category findCategoryById(Long id){
        return categoryRepository.getOne(id);
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public void removeCategory(Long id){
        categoryRepository.deleteById(id);
    }
    public List<Category> showAllCategories() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }
}
