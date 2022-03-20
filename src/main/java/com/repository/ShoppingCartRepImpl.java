package com.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.ShoppingCart;
@Repository
@Transactional
public class ShoppingCartRepImpl implements ShoppingCartRepo{
	@Autowired
	private SessionFactory factory;
	
	@Override
	public void saveShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(shoppingCart);
	}
	
	@Override
	public ShoppingCart findBySessionToken(String token) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(ShoppingCart.class);
		criteria.add(Restrictions.eq("sessionToken", token));
		ShoppingCart cart =(ShoppingCart)  criteria.uniqueResult();
		
		return cart;
	}

}
