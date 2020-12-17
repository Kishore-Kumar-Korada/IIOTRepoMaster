package com.kishorekumarkorada.IIOTDataVisualizer.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "iiot_shift")
@IdClass(IIOTShiftModelPK.class)
public class IIOTShiftModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shift_id")
	private String shiftId;
	
	@Id
	@ManyToOne
	@JoinColumn(name="machine_id", referencedColumnName = "machine_id")
	private IIOTMachineModel machine;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "start_time")
	private LocalTime startTime;
	
	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm:ss")
	@Column(name = "end_time")
	private LocalTime endTime;
	
	@Column(name= "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdOn;

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public IIOTMachineModel getMachine() {
		return machine;
	}

	public void setMachine(IIOTMachineModel machine) {
		this.machine = machine;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public IIOTShiftModel(String shiftId, LocalTime startTime, LocalTime endTime, IIOTMachineModel machine,
			LocalDateTime createdOn) {
		super();
		this.shiftId = shiftId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.machine = machine;
		this.createdOn = createdOn;
	}
	
	public IIOTShiftModel() {
		
	}
	
	
	
}
