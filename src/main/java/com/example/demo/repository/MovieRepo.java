package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Movie;


@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{

	//List<Movie> findByMovie_TitleContainingIgnoreCase(String movie_title);

}
