package woodstock.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import woodstock.game.GameState;
import woodstock.game.Main;

public class GameWindow {

	Font stabdardFont = new Font("Comic sans ms", Font.BOLD, 14);
	static FontMetrics fm;

	public GameButton[] buttons;

	private BufferedImage image;
	private Color colour;

	public int w, h;
	public int x, y;

	public boolean active;

	ArrayList<Message> messages = new ArrayList<>();

	public GameWindow(int w, int h, int colour, GameButton[] buttons) {
		x = Main.WIDTH / 2 - w / 2;
		y = Main.HEIGHT / 2 - h / 2;
		this.colour = new Color(colour);
		this.buttons = buttons;
	}

	public static class Message {
		int x, y;
		Font f;
		String text;

		public Message(int x, int y, Font f, String text) {
			this.x = x;
			this.y = y;
			this.f = f;
			this.text = text;
		}
	}

	public GameWindow(BufferedImage image) {
		this.image = image;
	}

	public void update() {
		if (active) {
			show();
			for (GameButton b : buttons) {
				b.tick();
			}
		}
	}

	public void show() {

		Graphics g = Main.g;
		if (image != null) {
			g.drawImage(image, x * GameState.renderScale, y * GameState.renderScale, w * GameState.renderScale,
					h * GameState.renderScale, null);
		}
		for (GameButton b : buttons) {
			b.render();
		}

	}

	public void showText() {
		for(Message m : messages) {
			Main.g.drawString(m.text, m.x * GameState.renderScale, m.y * GameState.renderScale);
		}
	}

	public void addMessage(int x, int y, Font f, String text) {
		messages.add(new Message(x, y, f, text));
	}

}
