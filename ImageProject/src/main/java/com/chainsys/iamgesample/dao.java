package com.chainsys.iamgesample;

import java.util.Arrays;

public class dao {
	    private int productID;
	    private String name;
	    private double price;
	    private String description;
	    private byte[] image;
	    private int categoryID;

	    // Constructors
	    public dao() {
	    }

	    public dao(int productID, String name, double price, String description, byte[] image, int categoryID) {
	        this.productID = productID;
	        this.name = name;
	        this.price = price;
	        this.description = description;
	        this.image = image;
	        this.categoryID = categoryID;
	    }

	    // Getters and Setters
	    public int getProductID() {
	        return productID;
	    }

	    public void setProductID(int productID) {
	        this.productID = productID;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public byte[] getImage() {
	        return image;
	    }

	    public void setImage(byte[] image) {
	        this.image = image;
	    }

	    public int getCategoryID() {
	        return categoryID;
	    }

	    public void setCategoryID(int categoryID) {
	        this.categoryID = categoryID;
	    }

		@Override
		public String toString() {
			return "dao [productID=" + productID + ", name=" + name + ", price=" + price + ", description="
					+ description + ", image=" + Arrays.toString(image) + ", categoryID=" + categoryID + "]";
		}
	    
	}

