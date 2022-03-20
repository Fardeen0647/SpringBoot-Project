package com.repository;

import java.util.List;

import com.model.Cart;
import com.model.Product;

public interface ProductRepository {
	
	public void saveStudent(Product product);
	
	public List<Product> findAll();
	
	public List<Product> findByCat(int cid);
	
	public void deleteProduct(Product product);
	
	public Product findByid(int pid);
	
	public void updateProduct(Product product);
	

	

}
