package com.kishorekumarkorada.IIOTDataVisualizer.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="iiot_product")
@IdClass(IIOTProductModelPK.class)
public class IIOTProductModel implements Serializable {
	
	private static final long serialVersionUID = 7807669404047523909L;
	
	@Id
	@Column(name = "product_id", length = 100)
	private String productId;
	
	@Column(name = "shift_id")
    private String shiftId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="shift_id", referencedColumnName="shift_id",
                        insertable = false, updatable = false),
            @JoinColumn(name="machine_id", referencedColumnName="machine_id", 
                        insertable = false, updatable = false)
    })
    private IIOTShiftModel shift;
	
	@Id
	@ManyToOne
	@JoinColumn(name="machine_id", referencedColumnName = "machine_id")
	private IIOTMachineModel machine;
	
	@Column(name = "line_id")
	private String lineId;
	
	private String variant;
	
	
	private String operatorName;
	private LocalDateTime productionStartTime;
	private LocalDateTime productionEndTime;
	private String currentStatus;
	private LocalDateTime rtc;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public IIOTMachineModel getMachine() {
		return machine;
	}
	public void setMachine(IIOTMachineModel machine) {
		this.machine = machine;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public LocalDateTime getProductionStartTime() {
		return productionStartTime;
	}
	public void setProductionStartTime(LocalDateTime productionStartTime) {
		this.productionStartTime = productionStartTime;
	}
	public LocalDateTime getProductionEndTime() {
		return productionEndTime;
	}
	public void setProductionEndTime(LocalDateTime productionEndTime) {
		this.productionEndTime = productionEndTime;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public LocalDateTime getRtc() {
		return rtc;
	}
	public void setRtc(LocalDateTime rtc) {
		this.rtc = rtc;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public IIOTProductModel(String productId, IIOTMachineModel machine, String lineId, String variant,
			IIOTShiftModel shift, String operatorName, LocalDateTime productionStartTime,
			LocalDateTime productionEndTime, String currentStatus, LocalDateTime rtc, LocalDateTime createdOn,
			LocalDateTime updatedOn) {
		super();
		this.productId = productId;
		this.machine = machine;
		this.lineId = lineId;
		this.variant = variant;
		this.operatorName = operatorName;
		this.productionStartTime = productionStartTime;
		this.productionEndTime = productionEndTime;
		this.currentStatus = currentStatus;
		this.rtc = rtc;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		if (Objects.nonNull(shift))
			this.shiftId = shift.getShiftId();
	}	
	
	public String getShiftId() {
		return shiftId;
	}
	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}
	public IIOTShiftModel getShift() {
		return shift;
	}
	public void setShift(IIOTShiftModel shift) {
        this.shift = shift;
        this.shiftId = shift.getShiftId();
    }
	public IIOTProductModel() {
		
	}
}
