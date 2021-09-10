package com.hamdibouallegue.datarestdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hamdibouallegue.datarestdemo.models.UserPass;

public interface UserLoginRepository extends CrudRepository<UserPass, Integer>{
	
	UserPass findByUserNameAndLoginPasswordAndIsActive(String userName,String loginPassword,String isActive);
	

}
