package com.kishorekumarkorada.IIOTDataVisualizer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTProductDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTProductModel;

@Transactional
@Repository
public class IIOTProductDaoImpl implements IIOTProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public boolean isProductnExists(String productId, String machineId) {
		String jpql = "from IIOTProductModel AS a WHERE a.productId = ?0 AND a.machineId = ?1";
		int count = entityManager.createQuery(jpql).setParameter(0, productId).setParameter(1, machineId).getResultList().size();
		return count>0;
	}
	
	@Override
	public void addProduct(IIOTProductModel productEntity) {
		entityManager.persist(productEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IIOTProductModel> getProductList() {
		return (List<IIOTProductModel>)entityManager.createQuery("SELECT t FROM IIOTProductModel AS t ORDER BY t.createdOn").getResultList();
	}

}
