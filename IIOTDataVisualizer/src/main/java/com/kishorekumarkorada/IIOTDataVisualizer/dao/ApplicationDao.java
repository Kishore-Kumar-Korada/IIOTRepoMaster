package com.kishorekumarkorada.IIOTDataVisualizer.dao;

import com.kishorekumarkorada.IIOTDataVisualizer.model.ApplicationEntity;

public interface ApplicationDao {
	public boolean isApplicationExists(String applicationName, String owner);
	public void addApplication(ApplicationEntity applicationEntity);
	public ApplicationEntity getApplicatioinById(int id);
	public void updateApplication(ApplicationEntity applicationEntity);
	public void deleteApplication(int id);
}
