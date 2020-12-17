package com.kishorekumarkorada.IIOTDataVisualizer.dao;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTMachineModel;

public interface IIOTMachineDao {
	
	boolean isMachineExists(String machineId);
	void addMachine(IIOTMachineModel machineModel);
	IIOTMachineModel getMachineById(String machineId);
}
