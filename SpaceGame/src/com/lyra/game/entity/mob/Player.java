package com.lyra.game.entity.mob;

import com.lyra.game.graphics.Screen;
import com.lyra.game.graphics.Sprite;
import com.lyra.game.input.Keyboard;

public class Player extends Mob {

	private Keyboard keyboard;
	private Sprite sprite;
	private int animation = 0;
	private boolean walking = false;

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
		if (animation < 10000) {
			animation++;
		} else {
			animation = 0;
		}

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
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		int resto = animation % 20;
		if (direction == 0) {
			if (walking) {
				if (resto < 5) {
					sprite = Sprite.playerRight1;
				}else if(resto > 5 && resto < 10){
					sprite = Sprite.playerRight2;
				}else if(resto > 15) {
					sprite = Sprite.playerRight3;
				}else {
					sprite = Sprite.playerRight4;
				}
			} else {
				sprite = Sprite.playerRight;
			}
		} else if (direction == 1) {
			if (walking) {
				if (resto < 5) {
					sprite = Sprite.playerLeft1;
				}else if(resto > 5 && resto < 10){
					sprite = Sprite.playerLeft2;
				}else if(resto > 15) {
					sprite = Sprite.playerLeft3;
				}else {
					sprite = Sprite.playerLeft4;
				}
			} else {
				sprite = Sprite.playerLeft;
			}
		}
		screen.renderPlayer(x, y, sprite);
	}

}