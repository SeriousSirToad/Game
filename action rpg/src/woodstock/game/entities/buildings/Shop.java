package woodstock.game.entities.buildings;

import woodstock.game.level.Level;
import woodstock.game.level.interior.int_00;
import woodstock.gfx.Assets;

public class Shop extends Building {
	
	public Shop(Level level, int x, int y) {
		super(level, x, y, Assets.shop, new int_00());
		makeStandardDoor(32, 0);
	}

}
