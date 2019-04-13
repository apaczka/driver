package pl.coderslab.driver.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.driver.model.Category;
import pl.coderslab.driver.service.CategoryService;

import java.util.Optional;

public class CategoryConverter implements Converter<String, Optional<Category>> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Optional<Category> convert(String s) {
        return categoryService.findCategoryById(Long.parseLong(s));

    }

}
