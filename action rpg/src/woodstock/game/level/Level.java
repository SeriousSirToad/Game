package woodstock.game.level;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.imageio.ImageIO;

import woodstock.game.GameState;
import woodstock.game.Main;
import woodstock.game.entities.Entity;

public abstract class Level {

	public static final int levelScale = (int) (4 * Main.SCALE);

	public BufferedImage image;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Rectangle> colliders = new ArrayList<Rectangle>();

	public static Level test = new lvl_test();
	protected int width = 0;
	protected int height = 0;

	private Comparator<Entity> entitySorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if (a.y + a.h < b.y + b.h)
				return -1;
			return 1;
		}
	};

	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
		entities.sort(entitySorter);
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
		init();
	}

	public abstract void init();

	public int getWidth() {
		return width * levelScale;
	}

	public int getHeight() {
		return height * levelScale;
	}

}
