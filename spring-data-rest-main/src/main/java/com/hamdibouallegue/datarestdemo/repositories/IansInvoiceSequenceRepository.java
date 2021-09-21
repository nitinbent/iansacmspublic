package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansInvoiceSequence;

@CrossOrigin(origins = "*")
public interface IansInvoiceSequenceRepository extends JpaRepository<IansInvoiceSequence, Integer> {
	
	IansInvoiceSequence findBySequenceTypeAndYearValueAndMonthValue(String sequenceType,String yearValue,String monthValue);
	
	 @Transactional
	 @Query("update IansInvoiceSequence u set u.sequenceStartValue = :sequenceStartValue where u.invoiceId = :invoiceId")
	 void updateSequenceStartValue(@Param("sequenceStartValue") Integer sequenceStartValue,@Param("invoiceId") Integer invoiceId);
	
}
