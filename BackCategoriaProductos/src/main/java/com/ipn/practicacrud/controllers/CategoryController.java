package com.ipn.practicacrud.controllers;

import com.ipn.practicacrud.models.Category;
import com.ipn.practicacrud.services.CategoryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        super();
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategryById(@PathVariable("id") int id){
        Category category = categoryService.getCategoryById(id);
        if(category!=null)
            return new ResponseEntity<>(category, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public  ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Category> updateCategory(@PathVariable("id") int id , @RequestBody Category category){
        Category currentUpdate = categoryService.updateCategory(id,category);
        if(currentUpdate == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(currentUpdate, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id")int id){
        boolean isCategoryDelete = categoryService.deleteCategoryById(id);
        if(isCategoryDelete)
            return new ResponseEntity<>("Registro eliminado correctamente",HttpStatusCode.valueOf(204));
        else
            return new ResponseEntity<>("Registro eliminado correctamente",HttpStatus.NOT_FOUND);

    }

}
