package com.kishorekumarkorada.IIOTDataVisualizer.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iiot_machine")
public class IIOTMachineModel {

	@Id
	@Column(name = "machine_id")
	private String machineId;
	
	@Column(name = "machine_name")
	private String machineName;
	
	@Column(name = "machine_description")
	private String machineDescription;

	@Column(name="created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdOn;

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		System.err.println("inside setMachineId: "+machineId);
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getMachineDescription() {
		return machineDescription;
	}

	public void setMachineDescription(String machineDescription) {
		this.machineDescription = machineDescription;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public IIOTMachineModel(String machineId, String machineName, String machineDescription, LocalDateTime createdOn) {
		super();
		this.machineId = machineId;
		this.machineName = machineName;
		this.machineDescription = machineDescription;
		this.createdOn = createdOn;
	}
	
	public IIOTMachineModel() {
		
	}

	@Override
	public String toString() {
		return "IIOTMachineModel [machineId=" + machineId + ", machineName=" + machineName + ", machineDescription="
				+ machineDescription + ", createdOn=" + createdOn + "]";
	}
	
	
	
	
}
