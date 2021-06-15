package org.rhlug.superrafting.superrafting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperRafting extends JavaPlugin{
	//potentially useful docs
	//https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/Vehicle.html
	@Override
	public void onEnable() {
		getLogger().info("SuperRafting enabled!");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//TODO Check sender is a player
		if(cmd.getName().equalsIgnoreCase("checkBoat")) {
			Player player = (Player) sender;
			if(player.isInsideVehicle()) {
				switch(player.getVehicle().getType()) {
				case BOAT:
					player.sendMessage("You're in a boat!");
					break;
				default:
					break;
				
				}
			}
			return true;
		}
		return false;
	}
}
