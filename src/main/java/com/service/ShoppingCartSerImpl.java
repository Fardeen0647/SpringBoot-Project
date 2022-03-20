package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.Product;
import com.model.ShoppingCart;
import com.repository.ShoppingCartRepImpl;
@Service
@Transactional
public class ShoppingCartSerImpl implements ShoppingCartSer {
	@Autowired
	private ShoppingCartRepImpl shoppingCartRepImpl;
	@Autowired
	private ProductServiceImple imple;
	
	@Override
	public void saveShoppingCart(ShoppingCart cart) {
		// TODO Auto-generated method stub
		
		
		shoppingCartRepImpl.saveShoppingCart(cart);
		
	}
	
	@Override
	public void addtoShoppingCart(int id,String sessionToken) {
		// TODO Auto-generated method stub
		ShoppingCart cart = new ShoppingCart();
		Product product = imple.findByid(id);
		
		Cart cartIteam = new Cart();
		cartIteam.setProduct(product);
		
		cart.getCartProducts().add(cartIteam);
		cart.setSessionToken(sessionToken);
	    shoppingCartRepImpl.saveShoppingCart(cart);
		
	}
	
	@Override
	public void addtoExisitingShoppingCart(int id, String sessionToken) {
		
		ShoppingCart cart = shoppingCartRepImpl.findBySessionToken(sessionToken);
		Product product = imple.findByid(id);
		
		Cart cartIteams = new Cart();
		cartIteams.setProduct(product);
		
		cart.getCartProducts().add(cartIteams);
		
		shoppingCartRepImpl.saveShoppingCart(cart);
		
		
	}
	
	@Override
	public ShoppingCart findBySessionToken(String sessionToken) {
		// TODO Auto-generated method stub
		ShoppingCart cart = shoppingCartRepImpl.findBySessionToken(sessionToken);
		return cart;
	}

} 
