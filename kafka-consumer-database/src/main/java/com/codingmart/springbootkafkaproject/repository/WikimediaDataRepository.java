package com.codingmart.springbootkafkaproject.repository;

import com.codingmart.springbootkafkaproject.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}
