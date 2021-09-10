package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansCustomer;

@CrossOrigin(origins = "*")
public interface IansCustomerRepository extends JpaRepository<IansCustomer, Integer> {
}
