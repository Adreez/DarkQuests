package sk.Adreez.DarkQuests.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import sk.Adreez.DarkQuests.Main;

public class onPlace implements Listener {

	@EventHandler
	public void onPlaceEvent(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		int ActiveQuest = Main.data.getActiveQuest(player.getName());
		
		String Objective = Main.quests.getQuests().getString("Quests." + ActiveQuest + ".Objective");
		String ObjectiveTarget = Main.quests.getQuests().getString("Quests." + ActiveQuest + ".Target").toString().toUpperCase();
		
		if (!Objective.isEmpty()) {
			if (Objective.contains("Place")) {
				if (e.getBlock().getType().equals(Material.valueOf(ObjectiveTarget))) {
					Main.data.addToProgress(player.getName());
				}
			}
		}
	}
}
