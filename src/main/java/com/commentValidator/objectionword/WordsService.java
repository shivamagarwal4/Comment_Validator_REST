package com.commentValidator.objectionword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordsService {
	
	@Autowired
	private WordRepo wordsRepo;
	
	public List<Words1> getAllWords(){
		List<Words1> words = new ArrayList<>();
		wordsRepo.findAll().forEach(words::add);
		return words;
	}
		
	public void addWords(Words1 word) {
		wordsRepo.save(word);
	}
	
	public void updateWords(String id, Words1 word) {
		wordsRepo.save(word);
	}
	
	public void deleteWords(String id) {
		wordsRepo.deleteById(id);
	}

	public boolean findByWord(String word) {
		if(wordsRepo.findByWord(word)) {
			return true;
		}
		return false;
	}

	public Object[] getWord() {
		
		return wordsRepo.findWord();
		
	}
}
