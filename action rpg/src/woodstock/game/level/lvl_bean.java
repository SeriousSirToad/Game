package woodstock.game.level;

import java.awt.Rectangle;

import woodstock.game.entities.flora.Tree;

public class lvl_bean extends Level {

	public lvl_bean() {
		super("res/level/lvl_bean.png");
	}

	public void init() {
		colliders.add(new Rectangle(1, 1, 10 * levelScale, 10 * levelScale));
		new Tree(this, 500, 0, 1);
	}

}
