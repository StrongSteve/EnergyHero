package com.energyhero.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "measurement")
public class Measurement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurement_seq_gen")
	@SequenceGenerator(name = "measurement_seq_gen", sequenceName = "seq_measurement")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "creationtimestamp")
	private Date creationTimestamp;

	@Column(name = "consumer", nullable = false)
	private Consumer consumer;

	@Column(name = "unit", nullable = false)
	private Unit unit;

	@Column(name = "value", nullable = false)
	private Double value;

	@Column(name = "householdid")
	private Long householdId;
	
	@Column(name = "userid")
    private Long userId;

	public Measurement() {
        this.creationTimestamp = new Date();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimeStamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getHouseholdId() {
		return householdId;
	}

	public void setHouseholdId(Long householdId) {
		this.householdId = householdId;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	@Override
	public String toString() {
		return "Measurement" + "id=" + id + '}';
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(this.id, ((Measurement) obj).id);
	}

	@Override
	public int hashCode() {
		return ((id == null) ? 0 : id.intValue());
	}
}
