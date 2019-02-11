package woodstock.game.entities.buildings;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import woodstock.game.GameState;
import woodstock.game.Main;
import woodstock.game.entities.Entity;
import woodstock.game.level.Door;
import woodstock.game.level.Level;

public class Building extends Entity {

	public Door door;
	public boolean inside = false;
	public Level interior;
	public Rectangle renderBounds;

	public Building(Level level, int x, int y, BufferedImage image, Level interior) {
		super(level, x, y, image);
		this.isSolid = true;
		collider = new Rectangle(x * GameState.renderScale, h - (33 * GameState.renderScale),
				96 * GameState.renderScale, 33 * GameState.renderScale);
		renderBounds = new Rectangle(this.x, this.y, w, h);
		this.interior = interior;
	}

	@Override
	public void update() {

		if (interior == null || door == null) {
			return;
		}

	}

	public void render() {
		if (GameState.camera.contains(this) && !renderBounds.contains(GameState.player.collider)) {
			Main.g.drawImage(image, x - GameState.camera.x, y - GameState.camera.y, w, h, null);
		}
	}

	protected void makeStandardDoor(int x, int y) {
		Rectangle doorRect = new Rectangle(this.x + (x * GameState.renderScale), this.h - (y * GameState.renderScale),
				32 * GameState.renderScale, 1);
		Rectangle door2 = new Rectangle(64 * GameState.renderScale, 112 * GameState.renderScale,
				32 * GameState.renderScale, 8 * GameState.renderScale);
		door = new Door(level, doorRect, interior, new Point(64 * GameState.renderScale, 79 * GameState.renderScale));
		new Door(interior, door2, level, new Point(this.x + (x * GameState.renderScale), this.h - (y * GameState.renderScale)));
	}

}
