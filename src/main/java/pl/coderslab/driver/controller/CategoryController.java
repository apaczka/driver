package pl.coderslab.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.driver.model.Advice;
import pl.coderslab.driver.model.Category;
import pl.coderslab.driver.service.AdviceService;
import pl.coderslab.driver.service.CategoryService;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AdviceService adviceService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> showAllCategories(){
        List<Category> list = new ArrayList<>();
        list = categoryService.showAllCategories();
        return list;
    }

    @RequestMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Category showCategory(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }
    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategory(@RequestBody Category category){
//        for (Advice advice : category.getAdvices()) {
//            adviceService.saveAdvice(advice);
//
//        }
        categoryService.saveCategory(category);

    }
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category updatedCategory = categoryService.findCategoryById(id);
//        updatedCategory.setAdvices(category.getAdvices());
        updatedCategory.setName(category.getName());
        categoryService.saveCategory(updatedCategory);
    }
}
