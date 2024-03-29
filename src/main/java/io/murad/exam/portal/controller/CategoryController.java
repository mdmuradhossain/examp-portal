package io.murad.exam.portal.controller;

import io.murad.exam.portal.model.Category;
import io.murad.exam.portal.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category")
@CrossOrigin("*")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long id) {
        Category category = categoryService.getCategory(id).get();
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @PutMapping("/edit/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("categoryId") Long id) {
        return new ResponseEntity<>(categoryService.updateCategory(category, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}
