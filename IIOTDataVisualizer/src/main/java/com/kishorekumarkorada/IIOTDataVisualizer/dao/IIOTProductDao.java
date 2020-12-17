package com.kishorekumarkorada.IIOTDataVisualizer.dao;

import java.util.List;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTProductModel;

public interface IIOTProductDao {
	boolean isProductnExists(String productId, String machineId);
	void addProduct(IIOTProductModel productEntity);
	List<IIOTProductModel> getProductList();
}
