package com.lyra.game.level;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.lyra.game.level.tile.Tile;

public class SpawnLevel extends Level {
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(this.getClass().getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Could not load level file");
		}
	}
	
	// Grass = 0xFF00FF00
		// Flower = 0xFFFFFF00
		// Rock = 0xFF7F7F00
//	protected void generateLevel() {
//		for (int i = 0; i < levelPixels.length; i++) {
//			if(levelPixels[i] == 0xFF00FF00) {
//				tiles[i] = Tile.grassTile;
//			}
//			if(levelPixels[i] == 0xFFFFFF00) {
//				tiles[i] = Tile.flowerTile;
//			}
//			if(levelPixels[i] == 0xFF7F7F00) {
//				tiles[i] = Tile.rockTile;
//			}
//		}
//	}

}
