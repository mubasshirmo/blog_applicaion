package com.example.blogappapis.controller;

import com.example.blogappapis.payloads.ApiResponse;
import com.example.blogappapis.payloads.CategoryDto;
import com.example.blogappapis.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto){
     CategoryDto categoryDto1= this.categoryService.createCategory(categoryDto);
     return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
     }
    //update
     @PutMapping("/{categoryId}")
     public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
      CategoryDto updatedCat=this.categoryService.updateCategory(categoryDto,categoryId);
      return new ResponseEntity<>(updatedCat,HttpStatus.OK);
     }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("category is deleted succesfully",true),HttpStatus.OK);
    }

    //get
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        List<CategoryDto> categoryDtos= this.categoryService.getCategory();
        return ResponseEntity.ok (categoryDtos);
    }

    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
       CategoryDto categoryDto= this.categoryService.getCategory(categoryId);
       return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }


}
