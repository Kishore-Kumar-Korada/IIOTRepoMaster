package com.kishorekumarkorada.IIOTDataVisualizer.service;

import java.util.List;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTProductModel;

public interface ProductService {
	boolean addProduct(IIOTProductModel productEntity);
	List<IIOTProductModel> getProductList();
}
