package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansService;

@CrossOrigin(origins = "*")
public interface IansServiceRepository extends JpaRepository<IansService, Integer> {
}
