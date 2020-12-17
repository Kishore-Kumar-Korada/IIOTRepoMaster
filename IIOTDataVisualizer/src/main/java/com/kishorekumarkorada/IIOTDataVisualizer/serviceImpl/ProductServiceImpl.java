package com.kishorekumarkorada.IIOTDataVisualizer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishorekumarkorada.IIOTDataVisualizer.dao.IIOTProductDao;
import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTProductModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private IIOTProductDao iiotProductDao;
	
	@Override
	public boolean addProduct(IIOTProductModel productEntity) {
		if(iiotProductDao.isProductnExists(productEntity.getProductId(), productEntity.getMachine().getMachineId())) {
			return false;
		} else {
			iiotProductDao.addProduct(productEntity);
			return true;
		}
	}

	@Override
	public List<IIOTProductModel> getProductList() {
		return iiotProductDao.getProductList();
	}

}
