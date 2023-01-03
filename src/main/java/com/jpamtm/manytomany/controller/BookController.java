package com.jpamtm.manytomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpamtm.manytomany.entity.Book;
import com.jpamtm.manytomany.entity.BookPublisher;
import com.jpamtm.manytomany.entity.Publisher;
import com.jpamtm.manytomany.repository.BookPublisherRepository;
import com.jpamtm.manytomany.repository.BookRepository;
import com.jpamtm.manytomany.repository.PublisherRepository;

@RestController
@RequestMapping("/bookpublish")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Autowired
	private BookPublisherRepository bookPublisherRepository;
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> books = bookRepository.findAll();
		System.out.println("Books: "+ books);
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@GetMapping("/publisher")
	public ResponseEntity<List<Publisher>> getPublisher() {
		List<Publisher> publishersList = publisherRepository.findAll();
		return new ResponseEntity<List<Publisher>>(publishersList, HttpStatus.OK);
	}
	
	@GetMapping("/bookpubisher")
	public ResponseEntity<List<BookPublisher>> getBookPublisher() {
		List<BookPublisher> bookPublishersList = bookPublisherRepository.findAll();
		return new ResponseEntity<List<BookPublisher>>(bookPublishersList, HttpStatus.OK);
	}
}
