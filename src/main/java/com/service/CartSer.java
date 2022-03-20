package com.service;

import java.util.List;

import com.model.Cart;

public interface CartSer {
	
	public void saveCart(Cart cart);
	
	public Cart findByid(int id);
	
	public List<Cart> cartProducts();

}
