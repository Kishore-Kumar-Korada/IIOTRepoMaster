package com.kishorekumarkorada.IIOTDataVisualizer.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.ApplicationDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.ApplicationEntity;

@Transactional
@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean isApplicationExists(String applicationName, String owner) {
		String jpql = "from ApplicationEntity AS a WHERE a.name = ?0 AND a.owner = ?1";
		int count = entityManager.createQuery(jpql).setParameter(0, applicationName).setParameter(1, owner).getResultList().size();
		return count>0;
	}

	@Override
	public void addApplication(ApplicationEntity applicationEntity) {
		entityManager.persist(applicationEntity);
	}
	
	@Override
	public ApplicationEntity getApplicatioinById(int id) {
		return entityManager.find(ApplicationEntity.class, id);
	}
	
	@Override
	public void updateApplication(ApplicationEntity applicationEntity) {
		ApplicationEntity applicationEntity2 = entityManager.find(ApplicationEntity.class, applicationEntity.getId());
		applicationEntity2.setName(applicationEntity.getName());
		applicationEntity2.setDescription(applicationEntity.getDescription());
		applicationEntity2.setOwner(applicationEntity.getOwner());
		entityManager.flush();
	}
	
	@Override
	public void deleteApplication(int id) {
		entityManager.remove(getApplicatioinById(id));
	}
}
