package net.roguedraco.infobutton;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		// Respect other plugins
		if (event.isCancelled()) {
			return;
		}

		if (InfoButtons.isButton(event.getClickedBlock())) {
			InfoButtons.getButton(event.getClickedBlock()).execute(
					event.getPlayer());
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		// Respect other plugins
		if (event.isCancelled()) {
			return;
		}

		// Is this button an InfoButton?
		if (InfoButtons.isButton(event.getBlock())) {
			// Delete the button
			InfoButtons.deleteButton(event.getBlock());
		}
	}
	
}
