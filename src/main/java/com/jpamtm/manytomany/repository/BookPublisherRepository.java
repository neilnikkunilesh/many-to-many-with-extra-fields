package com.jpamtm.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpamtm.manytomany.entity.BookPublisher;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
	
}
