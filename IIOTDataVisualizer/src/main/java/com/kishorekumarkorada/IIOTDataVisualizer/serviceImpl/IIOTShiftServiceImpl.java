package com.kishorekumarkorada.IIOTDataVisualizer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTShiftDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTShiftModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.IIOTShiftService;

@Service
public class IIOTShiftServiceImpl implements IIOTShiftService {

	@Autowired
	private IIOTShiftDao iiotShiftDao;
	
	@Override
	public boolean addShift(IIOTShiftModel shiftModel) {
		if(iiotShiftDao.isShiftExists(shiftModel.getShiftId(), shiftModel.getMachine().getMachineId())) {
			System.err.println("Inside iff");
			return false;
		} else {
			System.err.println("Inside else");
			iiotShiftDao.addShift(shiftModel);
			return true;
		}
	}

	@Override
	public boolean isShiftExists(String shiftId, String machineId) {
		return iiotShiftDao.isShiftExists(shiftId, machineId);
	}

	@Override
	public IIOTShiftModel getShiftByIds(String shiftId, String machineId) {
		return iiotShiftDao.getShiftByIds(shiftId, machineId);
	}
}
