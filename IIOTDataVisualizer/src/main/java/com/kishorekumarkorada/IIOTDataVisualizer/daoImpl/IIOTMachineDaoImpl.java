package com.kishorekumarkorada.IIOTDataVisualizer.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTMachineDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTMachineModel;

@Transactional
@Repository
public class IIOTMachineDaoImpl implements IIOTMachineDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean isMachineExists(String machineId) {
		String jpql = "from IIOTMachineModel AS a WHERE a.machineId = ?0";
		int count = entityManager.createQuery(jpql).setParameter(0, machineId).getResultList().size();
		return count>0;
	}
	
	@Override
	public void addMachine(IIOTMachineModel machineModel) {
		entityManager.persist(machineModel);
	}
	
	@Override
	public IIOTMachineModel getMachineById(String machineId) {
		return entityManager.find(IIOTMachineModel.class, machineId);		
	}
}
