package com.ipn.practicacrud.services;

import java.util.List;

import com.ipn.practicacrud.models.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category getRandomCategoty();
    Category saveCategory(Category category);
    Boolean deleteCategoryById(int id);
    Category updateCategory(int id, Category category);
}
