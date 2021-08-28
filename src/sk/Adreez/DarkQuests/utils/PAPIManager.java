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
    	
    	String error = "Error";
    	
        if(params.equalsIgnoreCase("creator")) {
            return player == null ? null : player.getName(); // "name" requires the player to be valid
        }
        
        if(params.equalsIgnoreCase("progress")) {
        	String progress = String.valueOf(Main.data.getProgress(player.getName().toString()));
            return progress;
        }
        if(params.equalsIgnoreCase("activequest")) {
        	String active = String.valueOf(Main.data.getActiveQuest(player.getName().toString()));
            return active;
        }
        if(params.equalsIgnoreCase("completedquests")) {
        	String active = String.valueOf(Main.data.getCompletedQuests(player.getName().toString()));
            return active;
        }
        
        return error; // Placeholder is unknown by the Expansion
    }

}
