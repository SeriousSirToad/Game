package woodstock.game.entities.flora;

import java.awt.image.BufferedImage;

import woodstock.game.entities.Entity;
import woodstock.game.level.Level;
import woodstock.gfx.Assets;

public class Tree extends Entity {

	public int type;

	public Tree(Level level, int x, int y, int type) {
		super(level, x, y, Assets.getTree(type));
		this.type = type;
		isSolid = true;
	}

	@Override
	public void update() {
		return;
	}
	
	public void generateHitbox() {
		if(type == 0) {
			
		}
	}

}
