package com.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.model.Catagories;
import com.model.Product;

public interface ProductService {
	
	public void saveStudent(MultipartFile file , String name ,String description , int price , int cid );
	
    public void deleteProduct(Product product);
//	
	public List<Product> findAll();
	
	public List<Product> findByCat(int cid);
//	
	public Product findByid(int pid);
	


	public void saveToShoppingCart(int id);

	public void updateProduct(int pid,MultipartFile file , String name ,String description , int price , int cid);

}
