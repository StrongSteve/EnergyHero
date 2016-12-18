package com.energyhero.service.household;

import java.util.List;

import com.energyhero.domain.Household;
import com.energyhero.transfer.CurrentUser;

public interface HouseholdService {

	List<Household> getAllAvailableHouseholds(CurrentUser user);

	List<Household> getAllAvailableHouseholds();
	
	Household getHouseholdById(Long id);

	Household saveHousehold(Household household);

	void deleteHousehold(Long id);

}
