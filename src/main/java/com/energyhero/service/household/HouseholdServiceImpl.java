package com.energyhero.service.household;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energyhero.domain.Household;
import com.energyhero.domain.Role;
import com.energyhero.repository.HouseholdRepository;
import com.energyhero.transfer.CurrentUser;

@Service
public class HouseholdServiceImpl implements HouseholdService {

	private HouseholdRepository householdRepository;

	@Autowired
	public void setHouseholdRepositoryRepository(HouseholdRepository householdRepository) {
		this.householdRepository = householdRepository;
	}

	@Override
	public List<Household> getAllAvailableHouseholds(CurrentUser user) {
		if (Objects.equals(user.getRole(), Role.ADMIN)) {
			return householdRepository.findAll();
		} else {
			return householdRepository.findByUserId(user.getId());
		}
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

}
