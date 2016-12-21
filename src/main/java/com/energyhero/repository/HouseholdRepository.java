package com.energyhero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energyhero.domain.Household;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
	List<Household> findByUserId(Long id);
}
