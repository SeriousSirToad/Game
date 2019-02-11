package woodstock.game.level;

import java.awt.Rectangle;

import woodstock.game.entities.Player;
import woodstock.game.entities.buildings.Shop;
import woodstock.game.entities.flora.Tree;

public class lvl_bean extends Level {

	public lvl_bean() {
		super("res/level/lvl_bean.png");
	}

	public void init() {
		player = new Player(this, 0, 0);
		new Shop(this, 51, 0);
	}

}
