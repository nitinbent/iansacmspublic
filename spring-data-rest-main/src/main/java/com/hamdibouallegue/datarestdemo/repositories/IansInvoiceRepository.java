package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansInvoice;

@CrossOrigin(origins = "*")
public interface IansInvoiceRepository extends JpaRepository<IansInvoice, Integer> {
}
