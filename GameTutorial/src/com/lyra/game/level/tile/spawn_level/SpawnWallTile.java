package com.lyra.game.level.tile.spawn_level;

import com.lyra.game.graphics.Screen;
import com.lyra.game.graphics.Sprite;
import com.lyra.game.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return true;
	}
}
