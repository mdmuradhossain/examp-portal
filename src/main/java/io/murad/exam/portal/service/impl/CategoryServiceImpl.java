package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.model.Category;
import io.murad.exam.portal.repository.CategoryRepository;
import io.murad.exam.portal.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category existCategory = categoryRepository.findById(id).get();
        existCategory.setTitle(category.getTitle());
        existCategory.setDescription(category.getDescription());
        existCategory.setQuizzes(category.getQuizzes());
        return categoryRepository.save(existCategory);
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(categoryRepository.findAll());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
