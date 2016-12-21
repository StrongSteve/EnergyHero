package com.energyhero.service.measurement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyhero.domain.Measurement;
import com.energyhero.repository.MeasurementRepository;
import com.energyhero.transfer.CurrentUser;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	private MeasurementRepository measurementRepository;

	@Autowired
	public void setMeasurementRepository(MeasurementRepository measurementRepository) {
		this.measurementRepository = measurementRepository;
	}

	@Override
	public List<Measurement> getAllAvailableMeasurements(CurrentUser user) {
		// if (Objects.equals(user.getRole(), Role.ADMIN)) {
		return measurementRepository.findAll();
		// }
	}

	@Override
	public List<Measurement> getAllAvailableMeasurements() {
		return measurementRepository.findAll();
	}

	@Override
	public Measurement getMeasurementById(Long id) {
		return measurementRepository.findOne(id);
	}

	@Override
	public Measurement saveMeasurement(Measurement measurement) {
		return measurementRepository.save(measurement);
	}

	@Override
	public void deleteMeasurement(Long id) {
		measurementRepository.delete(id);
	}

}
