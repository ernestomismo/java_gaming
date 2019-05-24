package com.lyra.game.graphics;

import java.util.Random;

import com.lyra.game.level.tile.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yy = y + yOffset;
//			if (y < 0 || y >= height) { 
//				break;
//			}
			for (int x = 0; x < width; x++) {
				int xx = x + xOffset;
//				if(x < 0 || x >= width) {
//					break;
//				}
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE ; 
				//pixels[x + y * width] = 0xff00ff;
				//pixels[x + y * width] = tiles[tileIndex];
				pixels[x + y * width] = Sprite.grass.pixels[(xx & 15) + (yy & 15) * Sprite.grass.SIZE];
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) {
					xa = 0;
				}
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
			
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for(int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) {
					xa = 0;
				}
				int color = sprite.pixels[x + y * sprite.SIZE];
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
