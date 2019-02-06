package woodstock.game;

import woodstock.game.entities.Player;
import woodstock.game.level.*;
import woodstock.gfx.Camera;

public class GameState {

	public static Player player;
	public static Camera camera;
	public static int levelSeason = 0;
	
	public static void init(){
		Level.test.tick();
		player = (Player) Level.test.entities.get(0);
		camera = new Camera(0, 0, player);
	}

}
