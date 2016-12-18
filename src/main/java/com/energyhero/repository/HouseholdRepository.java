package com.energyhero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energyhero.domain.Household;

public interface HouseholdRepository extends JpaRepository<Household, Long> {

}
