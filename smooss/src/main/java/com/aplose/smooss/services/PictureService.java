package com.aplose.smooss.services;

import java.io.File;

import com.aplose.smooss.model.Picture;
import com.aplose.smooss.model.User;
import com.aplose.smooss.tools.ImageTools;

public class PictureService {

	private static PictureService INSTANCE;

	private PictureService() {}

	public static PictureService getInstance() {	
		if (INSTANCE == null) {
			INSTANCE = new PictureService();
		}
		return INSTANCE;
	}

	public Picture createPicture(File picture, String name, String description, User author) {
		
		//Encode the picture 
		String pictureBase64 = ImageTools.encodeImageBase64(picture);	
		
		//Construct the picture
		Picture p = new Picture(pictureBase64, name, description, author);
		
		//Persist picture object
		JPASingleton.getInstance().getEntityManager().getTransaction().begin();
		JPASingleton.getInstance().getEntityManager().persist(p);
		JPASingleton.getInstance().getEntityManager().getTransaction().commit();
		
		return p;
	}

}