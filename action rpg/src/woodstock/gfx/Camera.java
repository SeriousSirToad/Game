package woodstock.gfx;

import java.awt.Color;

import woodstock.game.GameState;
import woodstock.game.Main;
import woodstock.game.entities.Entity;
import woodstock.game.entities.Mob;
import woodstock.game.level.Level;

public class Camera {

	public int x, y;
	private Mob entity;
	private Level level;

	public Camera(int x, int y, Mob attatchedEntity) {

		this.x = x;
		this.y = y;
		this.entity = attatchedEntity;
		this.level = entity.getLevel();

	}

	public Camera(int x, int y, Level level) {
		this.x = x;
		this.y = y;
		this.level = level;
	}

	public void render() {
		Main.g.setColor(Color.black);
		Main.g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		if (level != null)
			level.render();
		Main.g.drawString(entity.x + ", " + entity.y, entity.x - x, entity.y - y);
	}

	public void tick() {
		if (level != entity.getLevel()) {
			level = entity.getLevel();
		}
		if (entity != null && level != null) {
			followEntity();
		}
		if (level.getWidth() <= Main.WIDTH) {
			this.x = (level.getWidth() / 2) - Main.WIDTH / 2;
		}
		if (level.getHeight() <= Main.HEIGHT) {
			this.y = (level.getHeight() / 2) - Main.HEIGHT / 2;
		}
	}

	public void followEntity() {

		if (x > 0) {
			if (x + (Main.WIDTH / 2) > entity.x + (entity.w / 2)) {
				move(x - entity.speed, y);
			}

		}
		if (x + Main.WIDTH < entity.getLevel().getWidth()) {
			if (x + (Main.WIDTH / 2) < entity.x + (entity.w / 2)) {
				move(x + entity.speed, y);
			}
		}
		if (y > 0) {
			if (y + (Main.HEIGHT / 2) > entity.y + (entity.h / 2)) {
				move(x, y - entity.speed);
			}
		}
		if (y + Main.HEIGHT < entity.getLevel().getHeight()) {
			if (y + (Main.HEIGHT / 2) < entity.y + (entity.h / 2)) {
				move(x, y + entity.speed);
			}
		}

	}

	public void move(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public boolean contains(int x, int y) {
		if (x < this.x || y < this.y)
			return false;
		if (x > this.x + Main.WIDTH || y > this.y + Main.WIDTH)
			return false;
		return true;
	}

	public boolean contains(Entity e) {
		if (e.x + (e.w * GameState.renderScale) < x || e.y + e.h < y) {
			return false;
		}
		return true;
	}

}
