package com.lyra.game.entity;

import java.util.Random;

import com.lyra.game.graphics.Screen;
import com.lyra.game.level.Level;

public class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}

	public boolean isRemoved() {
		return removed;
	}

	public void remove() {
		removed = true;
	}
}
