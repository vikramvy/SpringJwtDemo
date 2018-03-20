package com.testdemo.security.jwtsecurity.service;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.testdemo.security.jwtsecurity.model.RegistrationForm;

public interface RegistrationRepository extends CrudRepository<RegistrationForm, String>{

	@Query("SELECT t FROM RegistrationForm t where t.firstName = ?1")
    public List<RegistrationForm> findByFirstName(String firstName);
}
