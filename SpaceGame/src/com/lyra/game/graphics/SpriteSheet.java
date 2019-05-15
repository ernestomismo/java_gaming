package com.lyra.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	//public final int SIZE;
	public int width;
	public int height;
	public int[] pixels;
	
	//public static SpriteSheet tiles = new SpriteSheet("/sheet.png", 1024);
	public static SpriteSheet spaceSoldier = new SpriteSheet("/M484SpaceSoldier.png", 530, 580);
	
	public SpriteSheet(String path, int width, int height) {
		//SIZE = size;
		this.width = width;
		this.height = height;
		this.path = path;
		pixels = new int[width*height];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(this.path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
