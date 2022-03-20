package com.repository;

import java.util.List;

import com.model.Cart;

public interface CartRepo {
	
	public void saveCart(Cart cart);
	
	public Cart findByid(int id);
	
	public List<Cart> cartProducts();

}
