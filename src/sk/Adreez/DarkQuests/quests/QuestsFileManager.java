package sk.Adreez.DarkQuests.quests;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import sk.Adreez.DarkQuests.Main;

public class QuestsFileManager {

	private Main plugin;
	private FileConfiguration questsConfig = null;
	private File questsFile = null;
	
	
	public QuestsFileManager(Main plugin) {
		this.plugin = plugin;
		saveDefaultQuests();
	}
	
	public void reloadQuests() {
		if (this.questsFile == null) 
			this.questsFile = new File(this.plugin.getDataFolder(), "quests.yml");
		
		this.questsConfig = YamlConfiguration.loadConfiguration(this.questsFile);
		
	}
	
	public FileConfiguration getQuests() {
		if (this.questsConfig == null)
			reloadQuests();
		
		return this.questsConfig;
	}
	
	public void saveQuests() {
		if (this.questsConfig == null || this.questsFile == null)
			return;
		
		try {
			this.getQuests().save(this.questsFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.plugin.getLogger().log(Level.SEVERE, "Could not save quests.yml");
		}
	}
	
	public void saveDefaultQuests() {
		if (this.questsFile == null)
			this.questsFile = new File("plugins/DAQuests/quests.yml");
		
		if (!this.questsFile.exists()) {
			this.plugin.saveResource("quests.yml", false);
		}
	}
}
