package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class ShoppingCart {
	@Id
	private int id;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Collection<Cart> cartProducts;
	
	private String sessionToken;
	
	private int totalPrice;
	
	
	

	public int getTotalPrice() {
		int sum = 0;
		for(Cart cart : this.cartProducts) {
			sum = sum + cart.getProduct().getPrice();
		}
		
		return sum;
	}

	

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public ShoppingCart() {
		cartProducts= new ArrayList<>();
	}

	public Collection<Cart> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Collection<Cart> cartProducts) {
		this.cartProducts = cartProducts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartProducts, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		return Objects.equals(cartProducts, other.cartProducts) && id == other.id;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", cartProducts=" + cartProducts + "]";
	}
	
	
	
	
	
	

}
