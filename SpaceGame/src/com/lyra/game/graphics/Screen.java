package com.lyra.game.graphics;

import java.util.Random;

public class Screen {

	public int width, height;
	public int[] pixels;
	public int xOffset, yOffset;

	public Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			if (y < 0 || y > height)
				continue;
			for (int x = 0; x < width; x++) {
				if (x < 0 || x > width)
					continue;
				pixels[x + y * width] = 0xff22ee;
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 50; y++) {
			int ya = y + yp;
			for(int x = 0; x < 50; x++) {
				int xa = x + xp;
				if(xa < -50 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) {
					xa = 0;
				}
				int color = sprite.pixels[x + y * 50];
				if(color != 0Xffff006e) {
					pixels[xa + ya * width] = color;
				}	
			}	
		}
	}
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
