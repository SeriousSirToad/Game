package woodstock.game.level;

import java.awt.Point;
import java.awt.Rectangle;

import woodstock.game.GameState;
import woodstock.game.entities.Entity;
import woodstock.game.entities.Player;

public class Door {

	Rectangle rect;
	Level nativeLevel;
	Level level;
	Point tpLocation;

	public Door(Level nativeLevel, Rectangle rect, Level level, Point tpLocation) {

		this.rect = rect;
		this.level = level;
		this.tpLocation = tpLocation;
		nativeLevel.doors.add(this);

	}

	public void tick() {
		Player player = GameState.player;
		if (rect.intersects(GameState.player.collider)) {
			GameState.player.setLevel(level);
			GameState.player.x = (int) tpLocation.getX();
			GameState.player.y = (int) tpLocation.getY();
			GameState.player.collider = new Rectangle(
					((int) tpLocation.getX() + (4 * Entity.entScale)),
					((int) tpLocation.getY() + (24 * Entity.entScale)),
					7 * Entity.entScale, 8 * Entity.entScale);
		}
	}

}
