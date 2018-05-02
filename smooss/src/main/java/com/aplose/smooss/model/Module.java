package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	private String name = "Default Module Name";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public enum TypeModule {
		PlaylistModule,TriCountModule,PicturesModule,ChatModule,MiniGameModule,CarpoolingModule,BringModule
	}
}