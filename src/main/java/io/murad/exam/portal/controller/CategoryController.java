package io.murad.exam.portal.controller;

import io.murad.exam.portal.model.Category;
import io.murad.exam.portal.model.Question;
import io.murad.exam.portal.model.Quiz;
import io.murad.exam.portal.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long id){
        Category category = categoryService.getCategory(id).get();
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }

}
