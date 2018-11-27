package woodstock.game;

import woodstock.game.entities.Player;
import woodstock.game.level.Level;
import woodstock.gfx.Camera;

public class GameState {

	public static Level currentLevel = Level.test;
	public static Player player = (Player) Level.test.entities.get(0);
	public static Camera camera = new Camera(0, 0, player);

}
