package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Picture Class, create a picture.
 * @author Smooss Team
 * Last revision Martin M.
 */
@Entity
public class Picture {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Lob
	private String pictureBase64;
	private String name;
	private String description;
	@ManyToOne
	private User author;
	@OneToMany
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Picture() {};
	
	public Picture(String pictureBase64, String name, String description, User author){
		this.pictureBase64 = pictureBase64;
		this.name = name;
		this.description = description;
		this.author = author;
	}
	
	public String getPictureBase64(){
		return pictureBase64;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String newDescription){
		this.description = newDescription;
	}
	
	public User getAuthor(){
		return author;
	}
	
	public List<Comment> getComments(){
		return comments;
		
	}
	
}
