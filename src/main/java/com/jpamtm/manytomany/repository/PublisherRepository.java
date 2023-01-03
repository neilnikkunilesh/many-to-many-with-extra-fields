package com.jpamtm.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpamtm.manytomany.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

}
