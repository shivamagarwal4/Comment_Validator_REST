package com.commentValidator.objectionword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordsController {
	
	@Autowired
	private WordsService wordsService;
	
	@RequestMapping("/obj")
	public List<Words1> getAllWords(){
		return wordsService.getAllWords();

	}
	
	@RequestMapping(method=RequestMethod.POST,value="/obj")
	public boolean addWord(@RequestBody Words1 words) {
		
		wordsService.addWords(words);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/obj/{id}")
	public void updateWord(@RequestBody Words1 words, @PathVariable String id) 
	{
		
		wordsService.updateWords(id, words);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/obj/{id}")
	public void deleteWord(@PathVariable String id) {
		wordsService.deleteWords(id);
	}
}
