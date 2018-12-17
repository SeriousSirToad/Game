package woodstock.gfx;

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
		if (level != null)
			level.render();
		Main.g.drawString(entity.x + ", " + entity.y, entity.x - x, entity.y
				- y);
	}

	public void tick() {
		if (level != entity.getLevel()) {
			level = entity.getLevel();
		}
		if (entity != null && level != null) {
			followEntity();
		}
	}

	public void followEntity() {

		if (x > 0) {
			if (x + (Main.WIDTH / 2) > entity.x + (entity.w / 2)) {
				x -= entity.speed;
			}

		}
		if (x + Main.WIDTH < entity.getLevel().getWidth()) {
			if (x + (Main.WIDTH / 2) < entity.x + (entity.w / 2)) {
				x += entity.speed;
			}
		}
		if (y > 0) {
			if (y + (Main.HEIGHT / 2) > entity.y + (entity.h / 2)) {
				y -= entity.speed;
			}
		}
		if (y + Main.HEIGHT < entity.getLevel().getHeight()) {
			if (y + (Main.HEIGHT / 2) < entity.y + (entity.h / 2)) {
				y += entity.speed;
			}
		}

	}

	public boolean contains(int x, int y) {
		return false;
	}

	public boolean contains(Entity e) {
		if (e.x + (e.w * Entity.entScale) < x || e.y + e.h < y) {
			return false;
		}
		return true;
	}

}
