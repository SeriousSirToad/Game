package woodstock.game.level;

import java.awt.Rectangle;

import woodstock.game.entities.Player;
import woodstock.game.entities.flora.Tree;

public class lvl_test extends Level {

	public lvl_test() {
		super("res/level/lvl_test.png");

		Rectangle bldg_0 = new Rectangle(8 * levelScale, 36 * levelScale,
				96 * levelScale, 44 * levelScale);
		colliders.add(bldg_0);
		new Player(this, 0, 0);
		new Tree(this, 500, 0, 0);
	}

}
