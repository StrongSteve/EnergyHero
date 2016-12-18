package com.energyhero.transfer;

import org.hibernate.validator.constraints.NotEmpty;

public class HouseholdCreateForm {

	@NotEmpty
	private String name;

	private int size;

	private int numberOfInhabitants;

	private Long userId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumberOfInhabitants() {
		return numberOfInhabitants;
	}

	public void setNumberOfInhabitants(int numberOfInhabitants) {
		this.numberOfInhabitants = numberOfInhabitants;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
