package woodstock.game.level;

import java.awt.Point;
import java.awt.Rectangle;

import woodstock.game.entities.Player;
import woodstock.game.entities.flora.Tree;

public class lvl_test extends Level {


	public lvl_test() {
		super("res/level/lvl_test.png");
	}

	public void init() {
		new Tree(this, 500, 0, 1);
	}

}
