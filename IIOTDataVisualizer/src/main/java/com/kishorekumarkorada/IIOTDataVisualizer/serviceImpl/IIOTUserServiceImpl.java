package com.kishorekumarkorada.IIOTDataVisualizer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTUserDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTRoleModel;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;
import com.kishorekumarkorada.IIOTDataVisualizer.security.IIOTUserDetailsModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.IIOTUserService;
import com.kishorekumarkorada.IIOTDataVisualizer.web.dto.UserDTO;



@Service("userService")
public class IIOTUserServiceImpl implements IIOTUserService,UserDetailsService {
	
	@Autowired
	@Qualifier("userDaoImpl")
	private IIOTUserDao iiotUserDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<IIOTUserModel> getListOfUsers() {
		return iiotUserDao.getListOfUsers();
	}

	@Override
	public IIOTUserModel save(UserDTO userDTO) {
		List<IIOTRoleModel> iiotRoleModels = getListOfRolesByRoles(userDTO.getRoles());
		IIOTUserModel iiotUserModel = null;
		if (iiotRoleModels != null && iiotRoleModels.size() > 0) {
			iiotUserModel = new IIOTUserModel(userDTO.getUserName(), userDTO.getUserPassword(), userDTO.getUserType(),
					userDTO.getUserStatus(), iiotRoleModels);
		} else {
			List<IIOTRoleModel> iiotRoleModelsV1 = new ArrayList<IIOTRoleModel>();
			for (String role : userDTO.getRoles()) {
				IIOTRoleModel iiotRoleModel = new IIOTRoleModel();
				iiotRoleModel.setUserRole(role);
				iiotRoleModelsV1.add(iiotRoleModel);
			}
			System.err.println("Encrypted Password: "+passwordEncoder.encode(userDTO.getUserPassword()));
			iiotUserModel = new IIOTUserModel(userDTO.getUserName(), passwordEncoder.encode(userDTO.getUserPassword()), userDTO.getUserType(),
					userDTO.getUserStatus(), iiotRoleModelsV1);
		}
		return iiotUserDao.addUser(iiotUserModel);
	}

	@Override
	public List<IIOTRoleModel> getListOfRolesByRoles(List<String> roles) {
		return iiotUserDao.getListOfRolesByRoles(roles);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		IIOTUserModel user = iiotUserDao.getUserByUserName(userName); 
		if(user == null) {
			throw new UsernameNotFoundException("UserName: "+ userName +" not found"); 
		}
		return new IIOTUserDetailsModel(user);
	}

}
