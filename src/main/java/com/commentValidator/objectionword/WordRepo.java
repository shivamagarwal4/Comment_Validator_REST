package com.commentValidator.objectionword;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WordRepo extends CrudRepository<Words1, String>{
	
	public boolean findByWord(String word);
	
	@Query(value = "SELECT word FROM words1", nativeQuery = true)
    public Object[] findWord();
}
