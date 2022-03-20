package com.service;

import java.util.List;

import com.model.Catagories;

public interface CatagorySer {
	
	public void saveCatagory(Catagories catagories);
	
	public List<Catagories> list ();
	
	public Catagories findByidcat(int cid);

}
