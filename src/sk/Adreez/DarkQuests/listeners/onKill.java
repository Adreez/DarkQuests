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
		
			int ActiveQuest = Main.data.getActiveQuest(e.getEntity().getKiller());
			
			String Objective = Main.questsyml.getQuests().getString("Quests." + ActiveQuest + ".Objective");
			String ObjectiveTarget = Main.questsyml.getQuests().getString("Quests." + ActiveQuest + ".Target").toUpperCase();
			
			int Progress = Main.data.getProgress(e.getEntity().getKiller());
			int NeededProgress = Main.data.getNeededProgress(e.getEntity().getKiller());
			
			if (!Objective.isEmpty()) {
				if (Objective.contains("Kill")) {
					if (e.getEntity().getType().toString().equals(ObjectiveTarget)) {
						if (Progress < NeededProgress) {
							Main.data.addToProgress(e.getEntity().getKiller());
						}
						else if (Progress >= NeededProgress) {
							Main.qm.setQuestAsCompleted(e.getEntity().getKiller());
						}
						
					}
				}
			}
			
		}
	}

}
