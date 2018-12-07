package woodstock.game.level;

import java.awt.Rectangle;

import woodstock.game.entities.Player;
import woodstock.game.entities.flora.Tree;

public class lvl_test extends Level {

	public Player player;

	public lvl_test() {
		super("res/level/lvl_test.png");
	}

	public void init() {
		player = new Player(this, 0, 0);
		new Tree(this, 500, 0, 1);
		colliders.add(new Rectangle(8 * levelScale, 36 * levelScale, 96 * levelScale, 44 * levelScale));
		for(int i = 0; i < colliders.size(); i++) {
			System.out.println("ur bean");
		}
	}

}
