package com.energyhero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.energyhero.domain.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}
