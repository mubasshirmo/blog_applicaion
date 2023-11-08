package com.example.blogappapis.repositories;

import com.example.blogappapis.entites.Category;
import com.example.blogappapis.entites.Post;
import com.example.blogappapis.entites.User;
import com.example.blogappapis.payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    //iski implementation class jpa or springboot hme bna kr dedega run time p
;
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category );

    List<Post> findByTitleContaining(String title);


}
