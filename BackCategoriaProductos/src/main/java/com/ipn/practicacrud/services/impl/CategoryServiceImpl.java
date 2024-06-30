package com.ipn.practicacrud.services.impl;

import com.ipn.practicacrud.models.Category;
import com.ipn.practicacrud.repository.Categoria.CategoryRepository;
import com.ipn.practicacrud.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository){
        super();
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @Override
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getRandomCategoty() {
        List<Category> categories = categoryRepository.findAll();
        return categories.get(new Random().nextInt(categories.size()));
    }

    @Override
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteCategoryById(int id) {
        Category current = categoryRepository.findById(id).orElse(null);
        if(current == null)
            return false;
        categoryRepository.delete(current);
        return true;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if(existingCategory == null)
            return null;
        existingCategory.setNombreCategoria(category.getNombreCategoria());
        existingCategory.setDescripcionCategoria(category.getDescripcionCategoria());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }
}
