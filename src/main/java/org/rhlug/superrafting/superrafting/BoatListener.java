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
	    if(vehicleRidingIn.getPassengers().size()<=0) {
	    	return;
	    }
	    Player p = (Player) vehicleRidingIn.getPassengers().get(0);
	    playerObs = new ConcreteObserver(p);
//	    p.sendMessage("Boat velocity is " + vehicleRidingIn.getVelocity() + " and player " + p.getVelocity());
    	switch(vehicleRidingIn.getType()) {
    		case BOAT:
				Block highestBlock = vehicleRidingIn.getWorld().getHighestBlockAt(vehicleRidingIn.getLocation());
				
				if(highestBlock.getType() == Material.SOUL_LANTERN) {
					p.sendMessage("Speed Boost Activated!");
					p.setWalkSpeed(4);
//					Vector currentVel = vehicleRidingIn.getVelocity(); 
//					Vector speedBoost = currentVel.multiply(1.5)
//					p.sendMessage("Your velocity is " + vehicleRidingIn.getVelocity().toString());
//					vehicleRidingIn.setVelocity(vehicleRidingIn.getVelocity().multiply(1.2d));
//					p.sendMessage("Your new velocity is " + vehicleRidingIn.getVelocity().toString());
					Entity e = (Entity) vehicleRidingIn;
					for(int i = 0; i < 2; i++) {
						p.sendMessage("Old velocity is " + e.getVelocity() + " and new is \n" + e.getVelocity().multiply(15d));
//						p.setVelocity(p.getVelocity().multiply(15d));
					}

				}
				break;
			default:
				break;
    	}
	}
	
}
