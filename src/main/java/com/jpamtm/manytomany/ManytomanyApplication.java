package com.jpamtm.manytomany;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpamtm.manytomany.entity.Book;
import com.jpamtm.manytomany.entity.BookPublisher;
import com.jpamtm.manytomany.entity.Publisher;
import com.jpamtm.manytomany.repository.BookRepository;
import com.jpamtm.manytomany.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class ManytomanyApplication {
	
    private final BookRepository bookRepository = null;
    private final PublisherRepository publisherRepository = null;

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}
	
	public void run(String... args) {
        // Create a couple of Book, Publisher and BookPublisher
        Publisher publisherA = new Publisher("Publisher A");
        Publisher publisherB = new Publisher("Publisher B");
        publisherRepository.saveAll(Arrays.asList(publisherA, publisherB));

        bookRepository.save(new Book("Book 1", new BookPublisher(publisherA, new Date()), new BookPublisher(publisherB, new Date())));
        bookRepository.save(new Book("Book 2", new BookPublisher(publisherA, new Date())));
    }

}
