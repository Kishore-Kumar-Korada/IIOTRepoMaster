package com.kishorekumarkorada.IIOTDataVisualizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishorekumarkorada.IIOTDataVisualizer.model.IIOTProductModel;
import com.kishorekumarkorada.IIOTDataVisualizer.service.ProductService;

@RestController
@RequestMapping("iiot")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<IIOTProductModel>> getAllProducts() {
		List<IIOTProductModel> productModels = productService.getProductList();
		System.err.println("Before returning is the data null: "+(productModels==null));
		return new ResponseEntity<List<IIOTProductModel>>(productModels,HttpStatus.OK);
	}
	
	public ResponseEntity<Object> createProduct() {
		return null;
	}
	
}
