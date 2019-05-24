package com.lyra.game.level.tile;

import com.lyra.game.graphics.Screen;
import com.lyra.game.graphics.Sprite;
import com.lyra.game.level.tile.spawn_level.SpawnFloorTile;
import com.lyra.game.level.tile.spawn_level.SpawnGrassTile;
import com.lyra.game.level.tile.spawn_level.SpawnHedgeTile;
import com.lyra.game.level.tile.spawn_level.SpawnWallTile;
import com.lyra.game.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grassTile = new GrassTile(Sprite.grass);
	public static Tile flowerTile = new FlowerTile(Sprite.flower);
	public static Tile rockTile = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
	
	public boolean solid() {
		return false;
	}
}
