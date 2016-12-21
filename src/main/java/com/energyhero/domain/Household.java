package com.energyhero.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "household")
public class Household {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "household_seq_gen")
	@SequenceGenerator(name = "household_seq_gen", sequenceName = "seq_household")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "size", nullable = false, unique = true)
	private int size;

	@Column(name = "number_inhabitants", nullable = false, unique = true)
	private int numberOfInhabitants;

	@Column(name = "userid")
    private Long userId;
	
	public Household() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Household{" + "id=" + id + ", name='" + name.replaceFirst("@.*", "@***") + '}';
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.id, ((Household) obj).id);
	}

	@Override
	public int hashCode() {
		return ((id == null) ? 0 : id.intValue());
	}
}
