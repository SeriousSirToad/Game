package woodstock.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	static SpriteSheet entities = new SpriteSheet("res/ss_entity.png");
	static SpriteSheet buildings = new SpriteSheet("res/ss_bldg.png");
	// Mobs
	public static final BufferedImage player = entities.getImage(0, 0, 16, 32);
	public static final Animation pl_hz = new Animation(10, entities.getAnimation(16, 0, 16, 32, 4), false);
	public static final Animation pl_u = new Animation(20, entities.getAnimation(144, 0, 16, 32, 3), true);
	public static final Animation pl_dn = new Animation(20, entities.getAnimation(80, 0, 16, 32, 3), true);

	// Flora
	public static BufferedImage getTree(int type) {
		switch (type) {
		case 1:
			return entities.getImage(32, 96, 32, 64);
		default:
			return entities.getImage(0, 96, 32, 64);
		}
	}

	//Buildings
	public static final BufferedImage bldg_00 = buildings.getImage(0, 0, 96, 80);
	
	// Misc
	public static final BufferedImage bean = entities.getImage(0, 240, 16, 16);

}
