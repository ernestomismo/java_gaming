package com.lyra.game.entity.mob;

import com.lyra.game.graphics.Screen;
import com.lyra.game.graphics.Sprite;
import com.lyra.game.input.Keyboard;

public class Player extends Mob {

	private Keyboard keyboard;
	private Sprite sprite;

	public Player(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Player(int x, int y, Keyboard keyboard) {
		this.x = x;
		this.y = y;
		this.keyboard = keyboard;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (keyboard.up)
			ya--;
		if (keyboard.down)
			ya++;
		if (keyboard.left)
			xa--;
		if (keyboard.right)
			xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
		}
	}

	public void render(Screen screen) {
		if (direction == 0) {
			sprite = Sprite.playerForward;
		} else if (direction == 2) {
			sprite = Sprite.playerBackward;
		} else if (direction == 1) {
			sprite = Sprite.playerRight;
		} else if (direction == 3) {
			sprite = Sprite.playerLeft;
		}
		screen.renderPlayer(x, y, sprite);
	}

}
