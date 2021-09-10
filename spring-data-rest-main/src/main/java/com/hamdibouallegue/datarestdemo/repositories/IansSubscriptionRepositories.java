package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hamdibouallegue.datarestdemo.models.IansSubscription;

@CrossOrigin(origins = "*")
public interface IansSubscriptionRepositories extends JpaRepository<IansSubscription, Integer> {

}
