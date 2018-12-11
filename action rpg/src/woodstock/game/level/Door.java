package woodstock.game.level;

import java.awt.Rectangle;

public class Door {

	Rectangle rect;
	Level level;
	Point tpLocation;
	
	public Door(Rectangle rect, Level level, Point tpLocation) {
		
		this.rect = rect;
		this.level = level;
		this.tpLocation = tpLocation;
		
	}
	
	public void tick(){
		if(rect.intersects(GameState.player.collider){
			GameState.player.setLevel(level);
			GameState.player.x = tpLocation.getX();
			GameState.player.y = tpLocation.getY();
		}
	}

}
