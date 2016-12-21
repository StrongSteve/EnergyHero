package com.energyhero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energyhero.domain.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
	List<Measurement> findByUserId(Long id);
}
