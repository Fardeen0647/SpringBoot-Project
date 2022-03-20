package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.repository.CartRepoImple;
@Service
@Transactional
public class CartSerimpl implements CartSer{
	@Autowired
	private CartRepoImple cartRepoImple;

	
	@Override
	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		
		cartRepoImple.saveCart(cart);
		
	}
	
	@Override
	public Cart findByid(int id) {
		// TODO Auto-generated method stub
		
		Cart cart = cartRepoImple.findByid(id);
		return cart;
	}
	
	@Override
	public List<Cart> cartProducts() {
		// TODO Auto-generated method stub
		List<Cart> cartProducts = cartRepoImple.cartProducts();
		return cartProducts;
	}
}
