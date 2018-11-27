package woodstock.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	static SpriteSheet entities = new SpriteSheet("res/ss_entity.png");
	//Mobs
	public static final BufferedImage player = entities.getImage(0, 0, 16, 32);
	public static final Animation pl_hz = new Animation(4, 10, entities.getAnimation(16, 0, 16, 32, 4));
	
	//Misc
	public static final BufferedImage bean = entities.getImage(0, 240, 16, 16);

}
