package woodstock.game.entities.npcs;

import java.awt.image.BufferedImage;

import woodstock.game.entities.Entity;
import woodstock.game.level.Level;
import woodstock.gfx.Animation;

public class NPC extends Entity{

	public NPC(Level level, int x, int y, BufferedImage image) {
		super(level, x, y, image);
		this.isSolid = true;
	}

	@Override
	public void update() {
		
	}

}
