package com.kishorekumarkorada.IIOTDataVisualizer.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTShiftDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTShiftModel;

@Transactional
@Repository
public class IIOTShiftDaoImpl implements IIOTShiftDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addShift(IIOTShiftModel shiftModel) {
		entityManager.persist(shiftModel);
	}
	
	@Override
	public IIOTShiftModel getShiftByIds(String shiftId, String machineId) {
		String jpql = "from IIOTShiftModel AS a WHERE a.shiftId = ?0 AND a.machine.machineId = ?1";
		return (IIOTShiftModel) entityManager.createQuery(jpql).setParameter(0, shiftId).setParameter(1, machineId).getSingleResult();
	}
	
	@Override
	public boolean isShiftExists(String shiftId, String machineId) {
		String jpql = "from IIOTShiftModel AS a WHERE a.shiftId = ?0 AND a.machine.machineId = ?1";
		int count = entityManager.createQuery(jpql).setParameter(0, shiftId).setParameter(1, machineId).getResultList().size();
		return count>0;
	}
}
