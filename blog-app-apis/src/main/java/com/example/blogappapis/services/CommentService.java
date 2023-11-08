package com.example.blogappapis.services;

import com.example.blogappapis.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto,Integer postId);

    void deleteComment(Integer commentId);

}
