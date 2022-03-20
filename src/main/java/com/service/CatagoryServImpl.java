package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Catagories;
import com.repository.CatagoryRepoImple;
@Service
@Transactional
public class CatagoryServImpl implements CatagorySer {
	@Autowired
	private CatagoryRepoImple repoImple;
	
	@Override
	public void saveCatagory(Catagories catagories) {
		// TODO Auto-generated method stub
		
		repoImple.saveCatagory(catagories);
		
	}
	
	@Override
	public List<Catagories> list() {
		// TODO Auto-generated method stub
		List<Catagories> list = repoImple.catagorieslist();
		return list;
	}
	
	@Override
	public Catagories findByidcat(int cid) {
		// TODO Auto-generated method stub
		Catagories catagories = repoImple.findByidcat(cid);
		return catagories;
	}
	
	

}
