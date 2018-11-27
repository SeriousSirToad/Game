package woodstock.game.level;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import woodstock.game.GameState;
import woodstock.game.Main;
import woodstock.game.entities.Entity;

public class Level {

	public static final Level test = new lvl_test();
	public static final int levelScale = (int) (4 * Main.SCALE);

	public BufferedImage image;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public Rectangle[] colliders;

	private int width = 0;
	private int height = 0;

	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
	}

	public void render() {
		Main.g.drawImage(image, 0 - GameState.camera.x, 0 - GameState.camera.y, getWidth(), getHeight(), null);

		for (Entity e : entities) {
			e.render();
		}

	}

	public Level(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
			width = image.getWidth();
			height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getWidth() {
		return width * levelScale;
	}

	public int getHeight() {
		return height * levelScale;
	}

}
