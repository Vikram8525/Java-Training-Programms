package com.chainsys.jfs.newstock;

public class StockManagementPojo {
		private String productName;
	    private int productId;
	    private int quantity;

	    public StockManagementPojo() {
	    }

	    public StockManagementPojo(String productName, int productId, int quantity) {
	        this.productName = productName;
	        this.productId = productId;
	        this.quantity = quantity;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public int getProductId() {
	        return productId;
	    }

	    public void setProductId(int productId) {
	        this.productId = productId;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

		@Override
		public String toString() {
			return "Product [productName=" + productName + ", productId=" + productId + ", quantity=" + quantity + "]";
		}
	}


