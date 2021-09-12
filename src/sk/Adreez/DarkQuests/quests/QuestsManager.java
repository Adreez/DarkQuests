package sk.Adreez.DarkQuests.quests;

import org.bukkit.entity.Player;

import sk.Adreez.DarkQuests.Main;

public class QuestsManager {

	public QuestsManager(Main plugin) {
	}
	
	public boolean CheckIfQuestsExists(String quest) {
		
		if (Main.questsyml.getQuests().getString("Quests." + quest) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setQuestAsCompleted(Player player) {
		
	}
	
	public void setQuest(Player player, int quest) {
		Main.data.setActiveQuest(player, quest);
		Main.data.resetProgress(player);
		Main.data.setNeededProgress(player, Integer.parseInt(Main.questsyml.getQuests().getString("Quests." + quest + ".Count")));
		
	}
	
	
}
