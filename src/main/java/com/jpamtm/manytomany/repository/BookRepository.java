package com.jpamtm.manytomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpamtm.manytomany.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	

}
