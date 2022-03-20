package com.repository;

import java.util.List;


import com.model.Catagories;

public interface CatagoryRepo {
	
	public void saveCatagory(Catagories catagories);
	
	public List<Catagories> catagorieslist();
	
	public Catagories findByidcat(int cid);

}
