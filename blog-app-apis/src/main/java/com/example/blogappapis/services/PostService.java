package com.example.blogappapis.services;

import com.example.blogappapis.entites.Post;
import com.example.blogappapis.payloads.PostDto;
import com.example.blogappapis.payloads.PostResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto,Integer postId);

    //Delete
    void deletePost(Integer postId);

    //get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sotDir);

    //get single post
    PostDto getPostById(Integer postId);


    //get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all post by user
    List<PostDto> getPostByUser(Integer userId);

    //search post
    List<PostDto> searchPosts(String keyword);

}
