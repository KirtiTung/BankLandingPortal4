package com.kirti.portal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirti.portal.entities.CustomerMasters;

public interface CustomerMastersRepo extends JpaRepository<CustomerMasters,String> {
		Optional<CustomerMasters> findByEmailId(String email);
}
