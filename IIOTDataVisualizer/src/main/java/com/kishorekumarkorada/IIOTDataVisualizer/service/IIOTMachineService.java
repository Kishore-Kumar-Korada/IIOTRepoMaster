package com.kishorekumarkorada.IIOTDataVisualizer.service;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTMachineModel;

public interface IIOTMachineService {
	boolean isMachineExists(String machineId);
	boolean addMachine(IIOTMachineModel machineModel);
	IIOTMachineModel getMachineById(String machineId);
}
