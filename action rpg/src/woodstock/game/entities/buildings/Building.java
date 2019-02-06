package woodstock.game.entities.buildings;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import woodstock.game.entities.Entity;
import woodstock.game.level.Level;

public class Building extends Entity{

	public Rectangle door;
	public boolean inside = false;
	public Level interior;
	
	public Building(Level level, int x, int y, BufferedImage image, Level interior) {
		super(level, x, y, image);
		this.isSolid = true;
	}

	@Override
	public void update() {
		
		if(interior == null || door == null){
			return;
		}
		
		for(Entity e : level.entities){
			if(e.isMob && e.collider.intersects(door)){
				e.setLevel(level);
			}
		}
	}
	
	public void generateInterior() {
		
	}

}
