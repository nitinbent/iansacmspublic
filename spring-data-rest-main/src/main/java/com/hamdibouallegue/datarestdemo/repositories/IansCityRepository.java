package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansCity;

@CrossOrigin(origins = "*")
public interface IansCityRepository extends JpaRepository<IansCity, Integer> {
}
