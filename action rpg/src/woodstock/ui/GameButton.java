package woodstock.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import woodstock.game.GameState;
import woodstock.game.Main;
import woodstock.io.InputHandler;

public class GameButton {

	private Rectangle buttonRect;

	private String text;
	
	public boolean hasBeenClicked = false;
	public boolean attatchedToEntity = false;
	protected boolean onThis = false;
	
	public Color color;
	public int numTimesClicked;
	
	public int x, y, width = 32, height = 16;
	
	protected InputHandler input;
	
	public BufferedImage buttonImage;

	public GameButton(int x, int y, BufferedImage image) {

		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getWidth();

		input = Main.input;

		buttonRect = new Rectangle(x, y, width, height);

	}

	public GameButton(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		buttonRect = new Rectangle(x, y, width, height);
	}

	public GameButton(int x, int y) {
		this.x = x;
		this.y = y;

		buttonRect = new Rectangle(x, y, width, height);
	}
	
	public GameButton(int x, int y, String text) {
		this.x = x;
		this.y = y;

		buttonRect = new Rectangle(x, y, width, height);
	}

	protected void onClick() {

	}

	public void tick() {

		buttonRect.x = x;
		buttonRect.y = y;
		buttonRect.width = width;
		buttonRect.height = height;

		if (hasBeenClicked && !input.clicking()) {
			onClick();
			hasBeenClicked = false;
		}

		if (buttonRect.contains(input.MouseX, input.MouseY)) {
			onThis = true;
		} else {
			onThis = false;
		}

	}

	Color kindaTransparent = new Color(255, 255, 255, 127);

	public void render() {
		Graphics g = Main.g;
		g.setColor(kindaTransparent);
		
		if(text != null) {
			g.drawString(text, x * GameState.renderScale, y * GameState.renderScale);
		}
		
		if (onThis) {
			g.fillRect(x * GameState.renderScale, y * GameState.renderScale, width * GameState.renderScale,
					height * GameState.renderScale);
		}
	}

}
