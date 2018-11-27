package woodstock.game.level;

import woodstock.game.entities.Player;
import woodstock.gfx.Assets;

public class lvl_test extends Level {

	public lvl_test() {
		super("res/level/lvl_test.png");
		new Player(this, 0, 0);
	}

}
