package com.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.Catagories;
@Repository
@Transactional
public class CartRepoImple implements CartRepo{
	@Autowired
	private SessionFactory factory;
	
	@Override
	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(cart);
		
	}
	
	@Override
	public Cart findByid(int id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Cart cart = session.get(Cart.class, Integer.valueOf(id));
		return cart;
	}
	
	@Override
	public List<Cart> cartProducts() {
		// TODO Auto-generated method stub
		Session session =  factory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Cart> cq = criteriaBuilder.createQuery(Cart.class);
		Root<Cart> root = cq.from(Cart.class);
		CriteriaQuery<Cart> all = cq.select(root);
		TypedQuery<Cart> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}
	
	

}
