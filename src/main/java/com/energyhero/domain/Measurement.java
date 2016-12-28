package com.energyhero.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "measurement")
public class Measurement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurement_seq_gen")
	@SequenceGenerator(name = "measurement_seq_gen", sequenceName = "seq_measurement")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "measuretimestamp")
	private Date measureTimestamp;

	@Column(name = "consumer", nullable = false)
	private Consumer consumer;

	@Column(name = "unit", nullable = false)
	private Unit unit;

	@Column(name = "value", nullable = false)
	private Double value;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "householdid")
	private Household household;

	@Column(name = "userid", nullable = false)
	private Long userId;

	public Measurement() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getMeasureTimestamp() {
		return measureTimestamp;
	}

	public void setMeasureTimestamp(Date measureTimestamp) {
		this.measureTimestamp = measureTimestamp;
	}

	public Household getHousehold() {
		return household;
	}

	public void setHousehold(Household household) {
		this.household = household;
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
