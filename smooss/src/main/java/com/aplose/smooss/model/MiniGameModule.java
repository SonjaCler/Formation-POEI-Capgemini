package com.aplose.smooss.model;

import javax.persistence.Entity;

@Entity
public class MiniGameModule extends Module{
	
	private Long id; 
	
	private String nameGame;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameGame() {
		return nameGame;
	}
	public void setNameGame(String nameGame) {
		this.nameGame = nameGame;
	} 
	

}
