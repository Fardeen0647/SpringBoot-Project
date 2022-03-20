package com.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Category")
public class Catagories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	@OneToMany(mappedBy = "catagories")
	private List<Product>mobiles ;
	
	
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Product> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<Product> mobiles) {
		this.mobiles = mobiles;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cid, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catagories other = (Catagories) obj;
		return cid == other.cid && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Catagories [cid=" + cid + ", name=" + name + "]";
	}
	
	
	
	

}
