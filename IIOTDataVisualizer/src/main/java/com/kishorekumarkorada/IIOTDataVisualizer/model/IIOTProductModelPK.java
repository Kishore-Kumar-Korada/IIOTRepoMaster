package com.kishorekumarkorada.IIOTDataVisualizer.model;

import java.io.Serializable;

public class IIOTProductModelPK  implements Serializable {
	
	private static final long serialVersionUID = 8282646586030104025L;
	private String productId;
	private String machine;
     
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}

     

}