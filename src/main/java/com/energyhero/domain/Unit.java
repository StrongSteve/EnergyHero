package com.energyhero.domain;

public enum Unit {
	KWH("kWh"), M3("m3");

	private final String name;

	private Unit(String s) {
		name = s;
	}

	public boolean equalsName(String otherName) {
		return (otherName == null) ? false : name.equals(otherName);
	}

	public String toString() {
		return this.name;
	}

}
