package com.service;

import com.model.ShoppingCart;

public interface ShoppingCartSer {
	
	public void saveShoppingCart(ShoppingCart cart);
	
	public void addtoShoppingCart(int id,String sessionToken);
	
	public void addtoExisitingShoppingCart(int id,String sessionToken);
	
	public ShoppingCart findBySessionToken(String sessionToken);

}
