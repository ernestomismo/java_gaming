package com.lyra.game.level;

import java.util.Random;

import com.lyra.game.graphics.Screen;
import com.lyra.game.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	protected int[] tilesInt;
	public static Level spawn = new Level("/levels/spawn.png");
	
	
	protected int tile_size;
	
	private Random random;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		setRandom(new Random());
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	public void update() {
		
	}
	
	public void render (int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	// Grass = 0xFF00FF00
	// Flower = 0xFFFFFF00
	// Rock = 0xFF7F7F00
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.voidTile;
		}
		if(tiles[x + y * width] == 0xFF00FF00) {
			return Tile.grassTile;
		}else if(tiles[x + y * width] == 0xFFFFFF00) {
			return Tile.flowerTile;
		}else if(tiles[x + y * width] == 0xFF7F7F00) {
			return Tile.rockTile;
		} else {
			return Tile.voidTile;
		}

	}
	
	private void time() {
		
	}
	
	protected void loadLevel(String path) {
		System.out.println("loadLevel de Level");;
		
	}

	protected void generateLevel() {
		for (int y = 0; y < 64; y++) {
			for (int x = 0; x < 64; x++) {
				getTile(x, y);
			}
		}
		tile_size = 16;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
	

}
