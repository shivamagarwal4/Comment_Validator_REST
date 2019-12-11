package com.commentValidator.comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commentValidator.objectionword.Words1;
import com.commentValidator.objectionword.WordsService;

@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private WordsService wordsService;
	
	
	@RequestMapping("/comments")
	public List<Comments> getAllComments(){
		return commentsService.getAllComments();

	}
	
	@RequestMapping(method=RequestMethod.POST,value="/comments")
	public boolean addComment(@RequestBody Comments comment) {
		
		 String sentence = comment.getComment(); 
		 String[] break_sentence = sentence.split(" "); 
		 Object[] objectionable =  wordsService.getWord();
		 System.out.println((objectionable[0].toString()));
		 System.out.println(Arrays.toString(break_sentence));

		 List<String> objString = new ArrayList<>();
		 for(int i=0;i<objectionable.length;i++) {
			 
			 objString.add(objectionable[i].toString());
		 }
		 for(int i =0 ; i < break_sentence.length; i++) 
		 {
			 if(objString.contains(break_sentence[i])) 
			 {
				  return false; 
			 }
			 else 
			 {
				 continue; 
			 } 
		 }
		
		commentsService.addComments(comment);
		return true;
	}
}
