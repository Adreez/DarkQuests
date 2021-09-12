package sk.Adreez.DarkQuests.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import sk.Adreez.DarkQuests.Main;


public class onDestroy implements Listener {
	
	@EventHandler
	public void onDestroyEvent(BlockBreakEvent e) {
		Player player = e.getPlayer();
		
		int ActiveQuest = Main.data.getActiveQuest(player);
		
		String Objective = Main.questsyml.getQuests().getString("Quests." + ActiveQuest + ".Objective");
		String ObjectiveTarget = Main.questsyml.getQuests().getString("Quests." + ActiveQuest + ".Target").toUpperCase();
		
		int Progress = Main.data.getProgress(e.getPlayer());
		int NeededProgress = Main.data.getNeededProgress(e.getPlayer());
		
		if (!Objective.isEmpty()) {
			if (Objective.contains("Destroy")) {
				if (e.getBlock().getType().equals(Material.valueOf(ObjectiveTarget))) {
					if (Progress < NeededProgress) {
						Main.data.addToProgress(player);
					}
					else if (Progress >= NeededProgress) {
						Main.qm.setQuestAsCompleted(e.getPlayer());
					}
				}
			}
		}
	}
}
