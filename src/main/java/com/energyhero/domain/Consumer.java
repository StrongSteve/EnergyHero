package com.energyhero.domain;

public enum Consumer {
	POWER("Strom"), HEATING("Heizung"), WATER("Wasser");

	private final String name;

	private Consumer(String s) {
		name = s;
	}

	public boolean equalsName(String otherName) {
		return (otherName == null) ? false : name.equals(otherName);
	}

	public String toString() {
		return this.name;
	}

}
