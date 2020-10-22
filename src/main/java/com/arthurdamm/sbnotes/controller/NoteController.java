package com.arthurdamm.sbnotes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurdamm.sbnotes.dao.NoteRepo;
import com.arthurdamm.sbnotes.model.Note;

@RestController
@RequestMapping("/api/v1")
public class NoteController {
	
	@Autowired
	NoteRepo repo;
	
	@GetMapping("/notes")
	List <Note> getNotes() {
		System.out.println("getNotes()");
		return repo.findAll();
	}
	
	@GetMapping("/note/{id}")
	Optional <Note> getNote(@PathVariable int id) {
		System.out.println("getNote(): " + id);
		return repo.findById(id);
	}
	
	@PostMapping("/note")
	Note postNote(@RequestBody Note note) {
		System.out.println("postNote(): " + note);
		return repo.save(note);
	}
	
	@DeleteMapping("/note/{id}")
	Note deleteNote(@PathVariable int id) {
		System.out.println("deleteNote(): " + id);
		Optional <Note> note = repo.findById(id);
		if (note.isEmpty())
			return null;
		repo.delete(note.get());
		return note.get();
	}
	
	@PutMapping("/note")
	Note putNote(@RequestBody Note note) {
		System.out.println("putNote(): " + note);
		return repo.save(note);
	}
	
	@GetMapping("/notes/reversed")
	List <Note> reversedNotes() {
		return repo.reverseSubjectOrder();
	}
	
}
