package com.vamikastore.vamika.services;

import com.vamikastore.vamika.dto.CategoryDto;
import com.vamikastore.vamika.dto.CategoryTypeDto;
import com.vamikastore.vamika.entities.Category;
import com.vamikastore.vamika.entities.CategoryType;
import com.vamikastore.vamika.exceptions.ResourceNotFoundEx;
import com.vamikastore.vamika.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategory(UUID categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElse(null);
    }

    public Category createCategory(CategoryDto categoryDto){
        Category category = mapToEntity(categoryDto);
        return categoryRepository.save(category);

    }

    private Category mapToEntity(CategoryDto categoryDto){
        Category category = Category.builder()
                .code(categoryDto.getCode())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .build();

        if(null != categoryDto.getCategoryTypes()){
            List<CategoryType> categoryTypes = mapToCategoryTypesList(categoryDto.getCategoryTypes(), category);
            category.setCategoryTypes(categoryTypes);
        }
        return category;
    }

    private List<CategoryType> mapToCategoryTypesList(List<CategoryTypeDto> categoryTypeList, Category category) {
        return categoryTypeList.stream().map(categoryTypeDto -> {
            CategoryType categoryType = new CategoryType();
            categoryType.setCode(categoryTypeDto.getCode());
            categoryType.setName(categoryType.getName());
            categoryType.setDescription(categoryTypeDto.getDescription());
            categoryType.setCategory(category);
            return categoryType;
        }).collect(Collectors.toList());
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(CategoryDto categoryDto, UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundEx("Category not found with Id "+categoryDto.getId()));

        if(null != categoryDto.getName()){
            category.setName(category.getName());
        }
        if(null != categoryDto.getCode()){
            category.setCode(category.getCode());
        }
        if(null != categoryDto.getDescription()){
            category.setDescription(categoryDto.getDescription());
        }

        List<CategoryType> existing = category.getCategoryTypes();
        List<CategoryType> list= new ArrayList<>();

        if(categoryDto.getCategoryTypes() != null){
           categoryDto.getCategoryTypes().forEach(categoryTypeDto -> {
               if (null != categoryTypeDto.getId()) {
                   Optional<CategoryType> categoryType = existing.stream().filter(t -> t.getId().equals(categoryTypeDto.getId())).findFirst();
                   CategoryType categoryType1 = categoryType.get();
                   categoryType1.setCode(categoryTypeDto.getCode());
                   categoryType1.setDescription(categoryTypeDto.getDescription());
                   list.add(categoryType1);
               } else {
                   CategoryType categoryType = new CategoryType();
                   categoryType.setCode(categoryTypeDto.getCode());
                   categoryType.setName(categoryType.getName());
                   categoryType.setDescription(categoryTypeDto.getDescription());
                   categoryType.setCategory(category);
                   list.add(categoryType);
               }
           });
        }
        category.setCategoryTypes(list);

        return categoryRepository.save(category);
    }

    public void deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
