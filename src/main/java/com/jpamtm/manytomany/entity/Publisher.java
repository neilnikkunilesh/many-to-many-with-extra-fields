package com.jpamtm.manytomany.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Publisher implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<BookPublisher> bookPublishers;

    
    public Publisher() {
		super();
	}

    
	public Publisher(int id, String name, Set<BookPublisher> bookPublishers) {
		super();
		this.id = id;
		this.name = name;
		this.bookPublishers = bookPublishers;
	}


	public Publisher(String name) {
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BookPublisher> getBookPublishers() {
		return bookPublishers;
	}

	public void setBookPublishers(Set<BookPublisher> bookPublishers) {
		this.bookPublishers = bookPublishers;
	}


	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", bookPublishers=" + bookPublishers + "]";
	}
    
	
    
}
