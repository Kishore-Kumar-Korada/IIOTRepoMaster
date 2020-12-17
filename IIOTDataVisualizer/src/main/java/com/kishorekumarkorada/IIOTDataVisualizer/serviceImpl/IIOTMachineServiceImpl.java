package com.kishorekumarkorada.IIOTDataVisualizer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTMachineDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTMachineModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.IIOTMachineService;

@Service
public class IIOTMachineServiceImpl implements IIOTMachineService {

	@Autowired
	private IIOTMachineDao iiotMachineDao;
	
	@Override
	public boolean addMachine(IIOTMachineModel machineModel) {
		if(iiotMachineDao.isMachineExists(machineModel.getMachineId())) {
			return false;
		} else {
			iiotMachineDao.addMachine(machineModel);
			return true;
		}
	}
	
	@Override
	public IIOTMachineModel getMachineById(String machineId) {
		return iiotMachineDao.getMachineById(machineId);
	}
	
	@Override
	public boolean isMachineExists(String machineId) {
		return iiotMachineDao.isMachineExists(machineId);
	}

}
