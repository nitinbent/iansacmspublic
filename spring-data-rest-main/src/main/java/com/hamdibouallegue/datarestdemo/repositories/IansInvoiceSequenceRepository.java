package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansInvoiceSequence;

@CrossOrigin(origins = "*")
public interface IansInvoiceSequenceRepository extends JpaRepository<IansInvoiceSequence, Integer> {
}
