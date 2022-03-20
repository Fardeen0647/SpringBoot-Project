package com.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Catagories;
@Repository
@Transactional
public class CatagoryRepoImple implements CatagoryRepo {
	@Autowired
	private SessionFactory factory;
	
	@Override
	public void saveCatagory(Catagories catagories) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(catagories);
		
	}
	
	@Override
	public List<Catagories> catagorieslist() {
		// TODO Auto-generated method stub
		Session session =  factory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Catagories> cq = criteriaBuilder.createQuery(Catagories.class);
		Root<Catagories> root = cq.from(Catagories.class);
		CriteriaQuery<Catagories> all = cq.select(root);
		TypedQuery<Catagories> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}
	
	@Override
	public Catagories findByidcat(int cid) {
		// TODO Auto-generated method stub
		Session session= factory.getCurrentSession();
		Catagories cat = session.get(Catagories.class, cid);
	 return cat;
	}

}
