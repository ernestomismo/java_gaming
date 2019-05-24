package com.lyra.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 16, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 32, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x21d1ab);
	
	// spawn level sprites
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
	
	// player sprites
	public static Sprite playerForward = new Sprite(32, 0, 160, SpriteSheet.tiles);
	public static Sprite playerBackward = new Sprite(32, 64, 160, SpriteSheet.tiles);
	public static Sprite playerLeft = new Sprite(32, 29, 50, SpriteSheet.tiles);
	public static Sprite playerRight = new Sprite(32, 16, 50, SpriteSheet.tiles);
	
	//public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x;
		this.y = y;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}		
	}

	public void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
}
