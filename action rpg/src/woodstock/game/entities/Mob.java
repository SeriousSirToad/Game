package woodstock.game.entities;

import java.awt.Color;
import java.awt.Rectangle;
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
		isMob = true;
		
	}

	public void tick() {
		if(!initialized)
			init();
		if (moving) {
			hz.update();
		}
		update();
	}

	@Override
	public abstract void update();

	public void move(int xa, int ya) {

		for (Rectangle r : level.colliders) {
			
			if (xa != 0 && ya != 0) {
				if (!hasCollided(0, ya, r)) {
					move(0, ya);
				}
				if (!hasCollided(xa, 0, r)) {
					move(xa, 0);
				}

				return;
			} else {
				if (hasCollided(xa, ya, r)) {
					return;
				}
			}
		}

		if (xa != 0 || ya != 0) {
			if (xa < 0) {
				movingDir = 0;
			} else if (xa > 0)
				movingDir = 2;
			else if (ya > 0)
				movingDir = 1;
			else
				movingDir = 3;
			moving = true;
		} else {
			moving = false;
		}

		x += xa;
		y += ya;
		collider.x += xa;
		collider.y += ya;

	}

	public boolean hasCollided(int xa, int ya, Rectangle other) {

		Rectangle temp = new Rectangle(collider.x + xa, collider.y + ya, w, h);

		if (temp.intersects(other)) {
			return true;
		}

		return false;
	}

	public void render() {
		for(Rectangle r : level.colliders){
			Main.g.setColor(Color.blue);
			Main.g.fill(r);
			Main.g.draw(collider);
		}
		if (GameState.camera.contains(this)) {
			if (!moving) {
				if (movingDir != 0) {
					Main.g.drawImage(image, x - GameState.camera.x, y
							- GameState.camera.y, w, h, null);
				} else {
					Main.g.drawImage(image, x - GameState.camera.x + (w), y
							- GameState.camera.y, -(w), h, null);
				}

			} else {
				if (movingDir != 0) {
					Main.g.drawImage(hz.animate(), x - GameState.camera.x, y
							- GameState.camera.y, (w), h, null);
				} else {
					Main.g.drawImage(hz.animate(),
							x - GameState.camera.x + (w), y
									- GameState.camera.y, -(w), h, null);
				}
			}
		}
	}

}
