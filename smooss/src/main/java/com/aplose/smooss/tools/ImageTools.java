package com.aplose.smooss.tools;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class ImageTools {
	
	@Deprecated
	public static String encodeImageBase64(File picture)
	{
		return encodeImageBase64(picture, "png");
	}
	
	public static String encodeImageBase64(File picture, String format) {
		String pictureBase64 = null;
		try {	
			//Encode the picture in base64
			BufferedImage bfr = ImageIO.read(picture);
			byte[] bytes;
			ByteArrayOutputStream outArray = new ByteArrayOutputStream();
			ImageIO.write(bfr, format, outArray);
			bytes = outArray.toByteArray();
			pictureBase64 = Base64.encodeBase64String(bytes);
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pictureBase64;
	}

}
