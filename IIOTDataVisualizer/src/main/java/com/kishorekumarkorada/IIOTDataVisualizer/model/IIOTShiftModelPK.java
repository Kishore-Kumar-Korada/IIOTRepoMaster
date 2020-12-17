package com.kishorekumarkorada.IIOTDataVisualizer.model;

import java.io.Serializable;

public class IIOTShiftModelPK  implements Serializable {

	private static final long serialVersionUID = 5253470289057718068L;

	private String machine;

     private String shiftId;

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

     
}