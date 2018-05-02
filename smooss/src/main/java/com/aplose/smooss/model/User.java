package com.aplose.smooss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique=true)
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String nickName;
	@Lob
	private String picture;
	
	public User(){}

	public User(String email, String password, String firstName, String lastName, String nickName, String picture) {
		
		this.email = email;
		this.password = new DigestUtils(DigestUtils.getDigest("MD5")).digestAsHex(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.picture = picture;
		
	}
	
	//Getters & Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = new DigestUtils(DigestUtils.getDigest("MD5")).digestAsHex(password);	
	}

	/* Cynthia & Ju >>*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/* << Cynthia & Ju */

	public void update(String email, String password, String firstName, String lastName, String nickName,
			String picture) {
		// TODO Auto-generated method stub
		
	}

}
