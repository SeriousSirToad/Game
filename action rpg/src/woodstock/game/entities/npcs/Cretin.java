package woodstock.game.entities.npcs;

import woodstock.game.level.Level;
import woodstock.gfx.Assets;

public class Cretin extends NPC {

	public Cretin(Level level, int x, int y) {
		super(level, x, y , Assets.cretin/*, Assets.cr_hz, Assets.cr_u, Assets.cr_dn */);
	}

}
