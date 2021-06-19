package org.rhlug.superrafting.superrafting;

import org.bukkit.entity.Player;

public class ConcreteObserver implements ServerMessageObserver {

	Player p;
	
	public ConcreteObserver(Player p) {
		this.p = p;
	}
	
	@Override
	public void notify(String message, Player p) {
		p.sendMessage(message);
	}

}
