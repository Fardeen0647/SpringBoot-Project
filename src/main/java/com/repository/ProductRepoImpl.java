package com.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public class ProductRepoImpl implements ProductRepository {
	@Autowired
	private SessionFactory factory;
	
	@Override
	public void saveStudent(Product product) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(product);
		
	}
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		CriteriaQuery<Product> all = cq.select(root);
		TypedQuery<Product> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}
	
	@Override
	public List<Product> findByCat(int cid) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Criteria c = session.createCriteria(Product.class);
		c.add(Restrictions.eq("catagories.cid", cid));
		List<Product>products=c.list();
		
		return products;
	}
	
	@Override
	public Product findByid(int pid) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Product product =  session.get(Product.class, pid);
		return product;
	}
	
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.update(product);
		
	}
	
	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		
		session.delete(product);
		
	}
	
}
