package com.energyhero.transfer;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.energyhero.domain.Consumer;
import com.energyhero.domain.Unit;

public class MeasurementCreateForm {

	private Consumer consumer;

	private Unit unit;

	@NotNull
	private Double value;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date measureTimestamp;

	@NotNull
	private Long householdId;

	private Long userId;

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

	public Date getMeasureTimestamp() {
		return measureTimestamp;
	}

	public void setMeasureTimestamp(Date measureTimestamp) {
		this.measureTimestamp = measureTimestamp;
	}

}
