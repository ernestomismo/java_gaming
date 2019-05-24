package com.lyra.game.level;

public class RandomLevel extends Level{
	
	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tilesInt[x + y * width] = getRandom().nextInt(4);
			}
		}
	}
	
}