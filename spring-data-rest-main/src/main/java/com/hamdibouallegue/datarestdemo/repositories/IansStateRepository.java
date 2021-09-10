package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansState;

@CrossOrigin(origins = "*")
public interface IansStateRepository extends JpaRepository<IansState, Integer> {
}
