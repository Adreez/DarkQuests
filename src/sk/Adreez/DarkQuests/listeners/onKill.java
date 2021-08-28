package sk.Adreez.DarkQuests.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import sk.Adreez.DarkQuests.Main;

public class onKill implements Listener {
	
	@EventHandler
	public void onKillEvent(EntityDeathEvent e) {
		
		if (e.getEntity().getKiller() instanceof Player) {
		
			int ActiveQuest = Main.data.getActiveQuest(e.getEntity().getKiller().getName().toString());
			
			String Objective = Main.quests.getQuests().getString("Quests." + ActiveQuest + ".Objective");
			String ObjectiveTarget = Main.quests.getQuests().getString("Quests." + ActiveQuest + ".Target").toString().toUpperCase();
			
			if (!Objective.isEmpty()) {
				if (Objective.contains("Kill")) {
					if (e.getEntity().getType().toString().equals(ObjectiveTarget)) {
						Main.data.addToProgress(e.getEntity().getKiller().getName().toString());
						e.getEntity().getKiller().sendMessage("TEST");
						
					}
				}
			}
			
		}
	}

}
