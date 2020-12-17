package com.kishorekumarkorada.IIOTDataVisualizer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTUserDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTRoleModel;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTUserModel;

@Transactional
@Repository(value="userDaoImpl")
public class IIOTUserDaoImpl implements IIOTUserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public IIOTUserModel getUserByUserName(String userName) {
		return entityManager.find(IIOTUserModel.class, userName);
	}
	
	@Override
	public boolean isUserExists(String userName) {
		IIOTUserModel user = entityManager.find(IIOTUserModel.class, userName);
		return user==null?false:true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IIOTUserModel> getListOfUsers() {
		String query = "SELECT u FROM IIOTUserModel AS u";
		return (List<IIOTUserModel>) entityManager.createQuery(query).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IIOTRoleModel> getListOfRolesByRoles(List<String> roles) {
		String query = "SELECT p FROM IIOTRoleModel AS p WHERE p.userRole in(:roles)";
		return (List<IIOTRoleModel>) entityManager.createQuery(query).setParameter("roles", roles).getResultList();
	}

	@Override
	public IIOTUserModel addUser(IIOTUserModel iiotUserModel) {
		entityManager.persist(iiotUserModel);
		return iiotUserModel;
	}

}
