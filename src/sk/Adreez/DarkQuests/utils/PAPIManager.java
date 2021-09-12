package sk.Adreez.DarkQuests.utils;

import org.bukkit.OfflinePlayer;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import sk.Adreez.DarkQuests.Main;

public class PAPIManager extends PlaceholderExpansion {

	@Override
	public String getAuthor() {
		return "Adreez_";
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return "daquests";
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "DEV-0.0.1";
	}
	
    @Override
    public String onRequest(OfflinePlayer player, String params) {
        
        if(params.equalsIgnoreCase("progress")) {
        	String progress = String.valueOf(Main.data.getProgress(player.getPlayer()));
            return progress;
        }
        
        if(params.equalsIgnoreCase("activequest")) {
        	String active = String.valueOf(Main.data.getActiveQuest(player.getPlayer()));
            return active;
        }
        
        if(params.equalsIgnoreCase("activequest_display_name")) {
        	
        	int ActiveQuest = Main.data.getActiveQuest(player.getPlayer());
        	
        	String QuestObjective = Main.questsyml.getQuests().getString("Quests." + ActiveQuest + ".Objective");
        	
        	if (QuestObjective == "Destroy") {
        		String active = Main.questsyml.getQuests().getString("Display." + QuestObjective + ".Name");
        		
        		return active;
        	}
        	else if (QuestObjective == "Kill") {
        		String active = Main.questsyml.getQuests().getString("Display." + QuestObjective + ".Name");
        		
        		return active;
        	}
        	
        	else if (QuestObjective == "Place") {
        		String active = Main.questsyml.getQuests().getString("Display." + QuestObjective + ".Name");
        		
        		return active;
        	}
 
        }
        
        if(params.equalsIgnoreCase("completedquests")) {
        	String active = String.valueOf(Main.data.getCompletedQuests(player.getPlayer()));
            return active;
        }
        if (params.equalsIgnoreCase("neededprogress")) {
        	String progress = String.valueOf(Main.data.getNeededProgress(player.getPlayer()));
        	return progress;
        }
        
        return "";
    }

}
