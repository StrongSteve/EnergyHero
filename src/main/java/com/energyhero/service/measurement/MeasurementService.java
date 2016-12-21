package com.energyhero.service.measurement;

import java.util.List;

import com.energyhero.domain.Measurement;
import com.energyhero.transfer.CurrentUser;

public interface MeasurementService {

	List<Measurement> getAllAvailableMeasurements(CurrentUser user);

	Measurement getMeasurementById(Long id);

	Measurement saveMeasurement(Measurement measurement);

	void deleteMeasurement(Long id);

}
