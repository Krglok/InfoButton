package net.roguedraco.infobutton;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class InfoButton {
	
	private Location location;
	
	private boolean enabled = false;
	private double price = 0.00;
	private String permission = "infobutton.use";
	
	private Set<ButtonAction> actions = new HashSet<ButtonAction>();

	public InfoButton(Block block) {
		this.location = block.getLocation();
		this.enabled = InfoButtonPlugin.getPlugin().getConfig().getBoolean("buttonDefaults.enabled");
		this.price = InfoButtonPlugin.getPlugin().getConfig().getDouble("buttonDefaults.price");
		this.permission = InfoButtonPlugin.getPlugin().getConfig().getString("buttonDefaults.permission");
	}

	public Location getLocation() {
		return location;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public double getPrice() {
		return price;
	}

	public String getPermission() {
		return permission;
	}

	public Set<ButtonAction> getActions() {
		return actions;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public void execute(Player player) {
		
	}

	public void addAction(ActionType type, String value) {
		ButtonAction action = new ButtonAction(type, value);
		this.addAction(action);
	}
	
	public void addAction(ButtonAction action) {
		actions.add(action);
	}
	
}
