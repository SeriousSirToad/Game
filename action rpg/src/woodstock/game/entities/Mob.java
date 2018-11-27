package woodstock.game.entities;

import java.awt.image.BufferedImage;

import woodstock.game.GameState;
import woodstock.game.Main;
import woodstock.game.level.Level;
import woodstock.gfx.Animation;

public abstract class Mob extends Entity {

	public int speed = 2;
	protected boolean moving = false;
	protected Animation hz;
	protected int movingDir = 0;

	public Mob(Level level, int x, int y, BufferedImage image, Animation hz) {
		super(level, x, y, image);
		this.hz = hz;
	}

	public void tick() {
		if (moving) {
			hz.update();
		}
		update();
	}

	@Override
	public abstract void update();

	public void move(int xa, int ya) {

		if (xa != 0 || ya != 0) {
			if (xa < 0)
				movingDir = 0;
			else if (xa > 0)
				movingDir = 2;
			else if (ya > 0)
				movingDir = 1;
			else
				movingDir = 3;
			moving = true;
		} else {
			moving = false;
		}

		if (xa != 0 && ya != 0) {
			move(0, ya);
			move(xa, 0);

			return;
		}

		x += xa;
		y += ya;

	}

	public void render() {
		if (GameState.camera.contains(this)) {
			if (!moving) {
				if (movingDir != 0) {
					Main.g.drawImage(image, x - GameState.camera.x, y - GameState.camera.y, w * entScale, h * entScale,
							null);
				} else {
					Main.g.drawImage(image, x - GameState.camera.x + (w * entScale), y - GameState.camera.y, -(w * entScale), h * entScale,
							null);
				}

			} else {
				if (movingDir != 0) {
					Main.g.drawImage(hz.animate(), x - GameState.camera.x, y - GameState.camera.y, (w * entScale),
							h * entScale, null);
				} else {
					Main.g.drawImage(hz.animate(), x - GameState.camera.x + (w * entScale), y - GameState.camera.y,
							-(w * entScale), h * entScale, null);
				}
			}
		}
	}

}
