package woodstock.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import woodstock.ui.GameButton;

public class Menu {

	private BufferedImage menuImage;
	public boolean playing = false;
	Font font = new Font("Comic sans ms", Font.BOLD, 10);
	GameButton start = new GameButton(149, 45, 112, 16);

	public Menu() {
		try {
			menuImage = ImageIO.read(new File("res/titleScreen.png"));
		} catch (IOException e) {
			System.out.println("nigga moment");
		}
	}

	public void render() {
		Graphics g = Main.g;
		g.drawImage(menuImage, 0, 0, menuImage.getWidth() * GameState.renderScale,
				menuImage.getHeight() * GameState.renderScale, null);
	}

}
