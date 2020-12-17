package com.kishorekumarkorada.IIOTDataVisualizer.service;

import com.kishorekumarkorada.IIOTDataVisualizer.model.ApplicationEntity;

public interface ApplicationService {

	boolean addApplication(ApplicationEntity applicationEntity);
	ApplicationEntity getApplicationById(int id);
	boolean updateApplication(ApplicationEntity applicationEntity);
	void deleteApplication(int id);
	

}
