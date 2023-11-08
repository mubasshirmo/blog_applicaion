package com.example.blogappapis.services;

import com.example.blogappapis.entites.Category;
import com.example.blogappapis.exceptions.ResourceNotFoundException;
import com.example.blogappapis.payloads.CategoryDto;
import com.example.blogappapis.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat=this.modelMapper.map(categoryDto, Category.class);
       Category addedCat= this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
       cat.setCategoryDescription(categoryDto.getCategoryDescription());
       cat.setCategoryTitle(categoryDto.getCategoryTitle());

       Category updatedcat=this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedcat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
     Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","category id ",categoryId));
     this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
       Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));

        return this.modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategory() {
       List<Category> categories= this.categoryRepo.findAll();
       List<CategoryDto> categoryDtos=categories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());

        return categoryDtos;
    }
}
