package org.rhlug.superrafting.superrafting;

import org.bukkit.entity.Player;

public interface ServerMessageObserver {
	void notify(String message, Player p);
	//void notify(String message, Player p);
}
