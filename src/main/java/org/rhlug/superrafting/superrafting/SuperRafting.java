package org.rhlug.superrafting.superrafting;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class SuperRafting extends JavaPlugin{
	//potentially useful docs
	//https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/Vehicle.html
	@Override
	public void onEnable() {
		getLogger().info("SuperRafting enabled!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new BoatListener(this), this);
	}
	

	
	
	
	private void didHitStar(Player p, Entity e) {

		switch(e.getType()) {
			case BOAT:
				p.sendMessage("DidHitStar boat velocity is " + e.getVelocity());
				break;
			default:
				break;
		
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//TODO Check sender is a player
		if(cmd.getName().equalsIgnoreCase("checkBoat")) {
			isPlaying = true;
			Player player = (Player) sender;
			if(player.isInsideVehicle()) {
				didHitStar(player, player.getVehicle());
			}
			return true;
		}
		return false;
	}
	
	
	private boolean isPlaying = false;
	
}
