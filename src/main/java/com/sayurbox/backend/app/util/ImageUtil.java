package com.sayurbox.backend.app.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ImageUtil {
    private final Logger log = LoggerFactory.getLogger(ImageUtil.class);

	public static String saveImage(String urlstr, String basePath, String fileName) {

		try {
			URL url = new URL(urlstr);
			BufferedImage image= ImageIO.read(url);

			File file=new File(basePath+fileName
					.replaceAll("[^A-Za-z0-9]+", "-")
					.replaceAll(" ", "-")
					.replaceAll("/", "-")
					.replaceAll(":", "")
					.toLowerCase()+".jpg"); 

			boolean success=ImageIO.write(image, "jpg", file);

			return file.getName();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "";
	}
}
