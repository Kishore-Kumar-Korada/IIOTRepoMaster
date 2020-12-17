package com.kishorekumarkorada.IIOTDataVisualizer.service;

import java.util.List;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTRoleModel;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;
import com.kishorekumarkorada.IIOTDataVisualizer.web.dto.UserDTO;

public interface IIOTUserService {
	public List<IIOTUserModel> getListOfUsers();
	public IIOTUserModel save(UserDTO userDTO);
	public List<IIOTRoleModel> getListOfRolesByRoles(List<String> roles);
}
