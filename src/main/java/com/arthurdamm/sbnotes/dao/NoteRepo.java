package com.arthurdamm.sbnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arthurdamm.sbnotes.model.Note;

public interface NoteRepo extends JpaRepository<Note, Integer> {
	
	@Query("from Note order by subject desc")
	List <Note> reverseSubjectOrder();
	
}
