package woodstock.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import woodstock.io.InputHandler;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = -5198863677834462653L;

	public int tickCount;

	GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	public static double SCALE = 1;
	private static final String NAME = "SnowFall";

	public boolean running = false;
	public JFrame frame = new JFrame();
	static final Dimension gameDimension = new Dimension((int) (WIDTH * SCALE), (int) (HEIGHT * SCALE));
	public static InputHandler input;

	public Main() {

		WIDTH *= SCALE;
		HEIGHT *= SCALE;

		frame.setTitle(NAME);
		frame.setSize(gameDimension);
		frame.setPreferredSize(gameDimension);
		frame.setMinimumSize(gameDimension);
		frame.setMaximumSize(gameDimension);
		frame.add(this, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		input = new InputHandler(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		System.out.println(WIDTH + ", " + HEIGHT);

	}

	float frames = 0;

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60;
		int ticks = 0;
		float frames = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		double delta2 = 0;

		while (running) {
			long now = System.nanoTime();
			double renderTime = 1000000000D / 60;
			delta += (now - lastTime) / nsPerTick;
			delta2 += (now - lastTime) / renderTime;
			lastTime = now;
			boolean shouldRender = true;
			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
			}

			while (delta2 >= 1) {
				delta2 -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				render();
				frames++;
			}
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " frames");
				this.frames = frames;
				ticks = 0;
				frames = 0;
			}

		}
	}

	public void tick() {

		tickCount++;

		GameState.currentLevel.tick();
		GameState.camera.tick();

	}

	BufferStrategy bs;
	public static Graphics2D g;

	int xOffset = 0;
	int yOffset = 0;

	public void render() {

		// Creating graphics object
		bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		g = (Graphics2D) bs.getDrawGraphics();
		// General Rendering
		g.clearRect(0, 0, (WIDTH), (HEIGHT));

		GameState.camera.render();

		bs.show();
		g.dispose();

	}

	public void start() {

		running = true;
		new Thread(this).start();

	}

	public static int scale(int num) {
		return (int) (num * SCALE);
	}

	public static void main(String[] args) {
		new Main().start();
	}

}
