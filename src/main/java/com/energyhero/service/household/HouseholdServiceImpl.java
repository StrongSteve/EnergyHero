package com.energyhero.service.household;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.energyhero.domain.Household;
import com.energyhero.repository.HouseholdRepository;
import com.energyhero.transfer.CurrentUser;

public class HouseholdServiceImpl implements HouseholdService {

	private HouseholdRepository householdRepository;

	@Autowired
	public void setHouseholdRepositoryRepository(HouseholdRepository householdRepository) {
		this.householdRepository = householdRepository;
	}

	@Override
	public List<Household> getAllAvailableHouseholds(CurrentUser user) {
		// if (Objects.equals(user.getRole(), Role.ADMIN)) {
		return householdRepository.findAll();
		// }
	}

	@Override
	public Household getHouseholdById(Long id) {
		return householdRepository.findOne(id);
	}

	@Override
	public Household saveHousehold(Household household) {
		return householdRepository.save(household);
	}

	@Override
	public void deleteHousehold(Long id) {
		householdRepository.delete(id);
	}

	@Override
	public List<Household> getAllAvailableHouseholds() {
		return householdRepository.findAll();
	}

}