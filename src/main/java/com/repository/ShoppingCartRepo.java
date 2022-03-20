package com.repository;

import com.model.ShoppingCart;

public interface ShoppingCartRepo {
	
	public void saveShoppingCart(ShoppingCart shoppingCart);
	
	public ShoppingCart findBySessionToken(String token);

}
