package sk.Adreez.DarkQuests.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sk.Adreez.DarkQuests.Main;

public class onJoin implements Listener {
	
	
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if (Main.SQL.isConnected()) {
			Main.data.createPlayer(player);
		}
		
		
		
	}
}
