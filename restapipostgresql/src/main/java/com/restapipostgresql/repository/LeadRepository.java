package com.restapipostgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapipostgresql.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer>{

	  List<Lead> findByMobilenumber(Long mobileNumber);
}
