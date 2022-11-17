package io.murad.exam.portal.service;

import io.murad.exam.portal.model.Category;

import java.util.Optional;
import java.util.Set;

public interface CategoryService {
    Optional<Category> getCategory(Long id);
    Category saveCategory(Category category);
    Category updateCategory(Category category,Long id);
    Set<Category> getCategories();
    void deleteCategory(Long id);

}
