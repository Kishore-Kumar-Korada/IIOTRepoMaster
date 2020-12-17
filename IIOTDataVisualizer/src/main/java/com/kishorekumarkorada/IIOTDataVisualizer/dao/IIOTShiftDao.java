package com.kishorekumarkorada.IIOTDataVisualizer.dao;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTShiftModel;

public interface IIOTShiftDao {

	void addShift(IIOTShiftModel shiftModel);
	boolean isShiftExists(String shiftId, String machineId);
	IIOTShiftModel getShiftByIds(String shiftId, String machineId);
	
}
