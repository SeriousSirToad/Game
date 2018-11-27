package woodstock.gfx;

import java.awt.image.BufferedImage;

public class Animation {

	public BufferedImage[] frames;
	public int frameSkip;
	private int frameIndex;

	public Animation(int i, int j, BufferedImage[] images) {

		frames = new BufferedImage[i];
		this.frameSkip = j;

		frames = images;

	}

	byte b = 0;

	public BufferedImage animate() {

		return frames[frameIndex];

	}

	public void update() {
		b++;

		if (b >= frameSkip) {

			frameIndex++;
			b = 0;

		}

		if (frameIndex >= frames.length) {
			frameIndex = 0;
		}
	}

	public void reset() {

		b = 0;
		frameIndex = 0;

	}

}
