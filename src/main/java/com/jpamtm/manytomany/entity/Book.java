package com.jpamtm.manytomany.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class Book implements Serializable{  

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<BookPublisher> bookPublishers;

    public Book(String name, BookPublisher... bookPublishers) {
        this.name = name;
        for(BookPublisher bookPublisher : bookPublishers) bookPublisher.setBook(this);
        this.bookPublishers = Stream.of(bookPublishers).collect(Collectors.toSet());
    }
    
	public Book() {
		super();
	}

	public Book(int id, String name, Set<BookPublisher> bookPublishers) {
		super();
		this.id = id;
		this.name = name;
		this.bookPublishers = bookPublishers;
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
		return "Book [id=" + id + ", name=" + name + ", bookPublishers=" + bookPublishers + "]";
	}
    
	
    
}
