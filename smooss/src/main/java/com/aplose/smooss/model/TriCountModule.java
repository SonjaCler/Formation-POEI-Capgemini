package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.List;

public class TriCountModule extends Module{
	
	private Long id;
	
	List<TriCountModule> tricount  = new ArrayList<TriCountModule>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TriCountModule> getTricount() {
		return tricount;
	}

	public void setTricount(List<TriCountModule> tricount) {
		this.tricount = tricount;
	}
	
	

}
