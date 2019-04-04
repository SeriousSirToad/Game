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

	public boolean hasBeenClicked = false;

	// private boolean canClick = true;
	public boolean attatchedToEntity = false;
	protected boolean onThis = false;
	public Color color;
	public int numTimesClicked;
	public int x, y, width, height;
	protected InputHandler input;
	public BufferedImage buttonImage;

	public GameButton(int x, int y, BufferedImage image) {

		this.x = x;
		this.y = y;
		this.width = GameState.renderScale * width;
		this.height = GameState.renderScale * height;

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
		if (onThis) {
			g.fillRect(x * GameState.renderScale, y * GameState.renderScale, width * GameState.renderScale,
					height * GameState.renderScale);
		}
	}

}
