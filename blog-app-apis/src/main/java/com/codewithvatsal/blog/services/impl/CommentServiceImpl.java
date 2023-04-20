package com.codewithvatsal.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithvatsal.blog.entities.Comment;
import com.codewithvatsal.blog.entities.Post;
import com.codewithvatsal.blog.exceptions.ResourceNotFoundException;
import com.codewithvatsal.blog.payloads.CommentDto;
import com.codewithvatsal.blog.repositories.CommentRepo;
import com.codewithvatsal.blog.repositories.PostRepo;
import com.codewithvatsal.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(() -> 
							new ResourceNotFoundException("Post", "post id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> 
						new ResourceNotFoundException("Comment", "comment id", commentId));	

		this.commentRepo.delete(comment);
	}

}
