package com.commentValidator.comments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commentValidator.objectionword.WordRepo;
import com.commentValidator.objectionword.Words1;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepo commentsRepo;
	
	public List<Comments> getAllComments(){
		List<Comments> comments = new ArrayList<>();
		commentsRepo.findAll().forEach(comments::add);
		return comments;
	}
	
	public void addComments(Comments Comment) {
		commentsRepo.save(Comment);
	}
	
	public void updateComments(String id, Comments Comment) {
		commentsRepo.save(Comment);
	}
	
	public void deleteComments(String id) {
		commentsRepo.deleteById(id);
	}
}
