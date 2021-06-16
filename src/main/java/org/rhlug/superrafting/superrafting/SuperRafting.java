package org.rhlug.superrafting.superrafting;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

public class SuperRafting extends JavaPlugin{
	//potentially useful docs
	//https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/Vehicle.html
	@Override
	public void onEnable() {
		getLogger().info("SuperRafting enabled!");
	}
	
	private boolean isEntityType(List<Entity> entities, EntityType t) {
		for(Entity nearbyEntity : entities) {
			EntityType test = nearbyEntity.getType();
			if(test.equals(t)) return true;
		}
		return false;
	}
	
	private void didHitStar(Player p, Entity e) {
		switch(e.getType()) {
			case BOAT:
				Boat b = (Boat) e;
				p.sendMessage("You're in a boat!");
				// currentVel = b.getVelocity();
				//b.setVelocity(new Vector(currentVel.getX()*1.5, currentVel.getY()*1.5, currentVel.getZ()*1.5));
				List<Entity> entities = b.getNearbyEntities(10,10,10);
				if(isEntityType(entities, EntityType.ARMOR_STAND)) {
					p.sendMessage("Congratulations!");
				}
				break;
			default:
				break;
		
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//TODO Check sender is a player
		if(cmd.getName().equalsIgnoreCase("checkBoat")) {
			Player player = (Player) sender;
			if(player.isInsideVehicle()) {
				didHitStar(player, player.getVehicle());
			}
			return true;
		}
		return false;
	}
	
	
}
