package com.arthurdamm.sbnotes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

	@Id
	@GeneratedValue
	private int id;
	
	private String subject;
	
	private String text;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", subject=" + subject + ", text=" + text + "]";
	}
	
}

