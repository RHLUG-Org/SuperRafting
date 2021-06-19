package org.rhlug.superrafting.superrafting;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

// https://github.com/ergor/hsrails/blob/master/src/main/java/st/netb/mc/hsrails/MinecartListener.java
public class BoatListener implements Listener {
	ServerMessageObserver playerObs;
	
	public BoatListener() {

	}
	
	/*private void notifyPassenger() {
		
	}*/
	
	private boolean isEntityType(List<Entity> entities, EntityType t) {
		for(Entity nearbyEntity : entities) {
			EntityType test = nearbyEntity.getType();
			if(test.equals(t)) return true;
		}
		return false;
	}
	
    @EventHandler(priority = EventPriority.NORMAL)
	public void onVehicleMove(VehicleMoveEvent event) {
	    Vehicle vehicleRidingIn = event.getVehicle();
	    Player p = (Player) vehicleRidingIn.getPassenger();
	    playerObs = new ConcreteObserver(p);
	    
    	switch(vehicleRidingIn.getType()) {
    		case BOAT:
				Block highestBlock = vehicleRidingIn.getWorld().getHighestBlockAt(vehicleRidingIn.getLocation());
				
				if(highestBlock.getType() == Material.LANTERN) {
					p.sendMessage("Speed Boost Activated!");
					Vector currentVel = vehicleRidingIn.getVelocity(); 
					Vector speedBoost = new Vector(currentVel.getX()*10, currentVel.getY()*10, currentVel.getZ()*10);
					vehicleRidingIn.setVelocity(currentVel);
				}
				
				//List<Entity> entities = b.getNearbyEntities(10,10,10);
				
				/*if(isEntityType(entities, EntityType.ARMOR_STAND)) {
					p.sendMessage("Congratulations! You earned 100 points!");
				}*/
				break;
			default:
				break;
    	}
	}
	
}
