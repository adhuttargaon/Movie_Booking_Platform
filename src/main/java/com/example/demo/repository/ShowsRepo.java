package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Shows;

public interface ShowsRepo extends JpaRepository<Shows, Integer>{

}
