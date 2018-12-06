package woodstock.game.level;

import woodstock.game.entities.Player;
import woodstock.game.entities.flora.Tree;

public class lvl_test extends Level {

	public lvl_test() {
		super("res/level/lvl_test.png");
		new Player(this, 100, 0);
		new Tree(this, 0, 0, 0);
	}

}
