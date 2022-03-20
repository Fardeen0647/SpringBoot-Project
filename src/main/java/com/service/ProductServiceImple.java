package com.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.model.Cart;
import com.model.Catagories;
import com.model.Product;
import com.model.ShoppingCart;
import com.repository.ProductRepoImpl;



@Service
@Transactional
public class ProductServiceImple implements ProductService {
	
	@Autowired
	private ProductRepoImpl repoImple;
	@Autowired
	private CatagoryServImpl catagoryServImpl;
	
	private CartSerimpl cartSerimpl;
	
	
	
	
	@Override
	public void saveStudent(MultipartFile file , String name , String description, int price, int cid) {
		// TODO Auto-generated method stub
		
		Product product = new Product(); 
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		
				
		product.setName(name);
		try {
			product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Catagories catagories =  catagoryServImpl.findByidcat(cid);
		
		product.setPrice(price);
		product.setDescription(description);
		product.setCatagories(catagories);
		
		repoImple.saveStudent(product);
		
	}
	
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		List<Product> products = repoImple.findAll();
		return products;
	}
	
	
	@Override
	public List<Product> findByCat(int cid) {
		// TODO Auto-generated method stub
		List<Product> products = repoImple.findByCat(cid);
		return products;
	}
	
	@Override
	public Product findByid(int pid) {
		// TODO Auto-generated method stub
		Product product = repoImple.findByid(pid);
		return product;
	}

	
	@Override
	public void saveToShoppingCart(int id) {
		// TODO Auto-generated method stub
		List<Cart> carts = cartSerimpl.cartProducts();
		ShoppingCart cart = new ShoppingCart();
		cart.setCartProducts(carts);
		
	}
	
	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		repoImple.deleteProduct(product);
	}
	
	@Override
	public void updateProduct(int pid,MultipartFile file , String name ,String description , int price , int cid) {
		// TODO Auto-generated method stub
		
		Product product = repoImple.findByid(pid);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		
				
		product.setName(name);
		try {
			product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Catagories catagories =  catagoryServImpl.findByidcat(cid);
		
		product.setPrice(price);
		product.setDescription(description);
		product.setCatagories(catagories);
		
		
		
		repoImple.updateProduct(product);
	}

	
	
		

	
	

}
