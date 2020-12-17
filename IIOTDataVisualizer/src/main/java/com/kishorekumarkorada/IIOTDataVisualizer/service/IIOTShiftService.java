package com.kishorekumarkorada.IIOTDataVisualizer.service;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTShiftModel;

public interface IIOTShiftService {
	boolean addShift(IIOTShiftModel shiftModel);
	boolean isShiftExists(String shiftId, String machineId);
	IIOTShiftModel getShiftByIds(String shiftId, String machineId);
}
