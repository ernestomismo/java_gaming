package com.lyra.game.entity.mob;

import com.lyra.game.entity.Entity;
import com.lyra.game.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int direction = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0)
			direction = 1; // east
		if (xa < 0)
			direction = 3; // west
		if (ya > 0)
			direction = 2; // south
		if (ya < 0)
			direction = 0; // north
		if (!collision()) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	private boolean collision() {
		return false;
	}

	public void render() {

	}

}