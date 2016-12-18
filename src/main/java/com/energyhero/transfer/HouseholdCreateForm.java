package com.energyhero.transfer;

import org.hibernate.validator.constraints.NotEmpty;

public class HouseholdCreateForm {

	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
