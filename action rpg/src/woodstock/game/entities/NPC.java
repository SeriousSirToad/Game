package woodstock.game.entities;

import java.awt.image.BufferedImage;

import woodstock.game.level.Level;
import woodstock.gfx.Animation;

public class NPC extends Mob{

	public NPC(Level level, int x, int y, BufferedImage image, Animation hz, Animation up, Animation dn) {
		super(level, x, y, image, hz, up, dn);
		this.isSolid = true;
	}

	@Override
	public void update() {
		
	}

}
