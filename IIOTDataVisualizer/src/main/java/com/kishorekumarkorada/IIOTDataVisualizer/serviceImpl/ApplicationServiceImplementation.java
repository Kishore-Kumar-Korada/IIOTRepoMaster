package com.kishorekumarkorada.IIOTDataVisualizer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.ApplicationDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.ApplicationEntity;
import com.kishorekumarkorada.IIOTDataVisualizer.service.ApplicationService;

@Service
public class ApplicationServiceImplementation implements ApplicationService {

	@Autowired
	private ApplicationDao applicationDao;
	
	@Override
	public synchronized boolean addApplication(ApplicationEntity applicationEntity) {
		if(applicationDao.isApplicationExists(applicationEntity.getName(), applicationEntity.getOwner()))
			return false;
		else {
			applicationDao.addApplication(applicationEntity);
			return true;
		}
	}
	
	@Override
	public ApplicationEntity getApplicationById(int id) {
		return applicationDao.getApplicatioinById(id);
	}
	
	@Override
	public boolean updateApplication(ApplicationEntity applicationEntity) {
		applicationDao.updateApplication(applicationEntity);
		return true;
	}
	
	@Override
	public void deleteApplication(int id) {
		applicationDao.deleteApplication(id);
	}

}
