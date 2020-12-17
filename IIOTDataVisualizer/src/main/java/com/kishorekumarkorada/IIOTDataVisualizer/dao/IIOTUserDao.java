package com.kishorekumarkorada.IIOTDataVisualizer.dao;

import java.util.List;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTRoleModel;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;

public interface IIOTUserDao {
	public IIOTUserModel getUserByUserName(String userName);
	public List<IIOTUserModel> getListOfUsers();
	public List<IIOTRoleModel> getListOfRolesByRoles(List<String> roles);
	public IIOTUserModel addUser(IIOTUserModel iiotUserModel);
	public boolean isUserExists(String userName);
}
