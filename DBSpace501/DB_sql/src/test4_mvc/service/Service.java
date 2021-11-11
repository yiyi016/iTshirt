package test4_mvc.service;

import java.util.Vector;

import test4_mvc.dto.Product;

public interface Service {
	
	void addProduct(); // insert
	void editProduct();  // update
	void delProduct(); //delete
	Product getProduct();// select one
	Vector<Product> getProducts(); // select all
	

}
