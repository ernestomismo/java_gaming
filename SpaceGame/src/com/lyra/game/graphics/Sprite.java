package com.lyra.game.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x21d1ab);
	
	public static Sprite playerLeft = new Sprite(45, 60, 15, SpriteSheet.spaceSoldier);
	public static Sprite playerLeft1 = new Sprite(45, 10, 125, SpriteSheet.spaceSoldier);
	public static Sprite playerLeft2 = new Sprite(45, 62, 125, SpriteSheet.spaceSoldier);
	public static Sprite playerLeft3 = new Sprite(45, 112, 125, SpriteSheet.spaceSoldier);
	public static Sprite playerLeft4 = new Sprite(45, 162, 125, SpriteSheet.spaceSoldier);
	public static Sprite playerRight = new Sprite(45, 10, 15, SpriteSheet.spaceSoldier);
	public static Sprite playerRight1 = new Sprite(45, 10, 70, SpriteSheet.spaceSoldier);
	public static Sprite playerRight2 = new Sprite(45, 62, 70, SpriteSheet.spaceSoldier);
	public static Sprite playerRight3 = new Sprite(45, 112, 70, SpriteSheet.spaceSoldier);
	public static Sprite playerRight4 = new Sprite(45, 162, 70, SpriteSheet.spaceSoldier);
	
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
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.width];
			}
		}
	}
	
}
