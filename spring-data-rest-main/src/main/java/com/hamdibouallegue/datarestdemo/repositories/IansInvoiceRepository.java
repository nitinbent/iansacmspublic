package com.hamdibouallegue.datarestdemo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansInvoice;

@CrossOrigin(origins = "*")
public interface IansInvoiceRepository extends JpaRepository<IansInvoice, Integer> {
	
	
    //@Query("select m from IansInvoice m where subscriptionDate >= :fifteenDaysAfterDateFromCurrent")
    @Query("select m from IansInvoice m where subscriptionDate between CURRENT_DATE and :fifteenDaysAfterDateFromCurrent")
    List<IansInvoice> findAllWithDateAfter(@Param("fifteenDaysAfterDateFromCurrent") Date fifteenDaysAfterDateFromCurrent);

    List<IansInvoice> findBySubscriptionDateBetweenAndInvoiceStatus(Date startDate, Date fifteenDaysAfterDateFromCurrent, String invoiceStatus);
    
    IansInvoice findByInvoiceId(int invoiceId);
    
    List<IansInvoice> findAllByOrderByCreatedAtDesc();
    
}
