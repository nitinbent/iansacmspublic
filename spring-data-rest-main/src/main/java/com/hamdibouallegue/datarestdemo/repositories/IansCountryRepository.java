package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansCountry;

@CrossOrigin(origins = "*")
public interface IansCountryRepository extends JpaRepository<IansCountry, Integer> {
}
