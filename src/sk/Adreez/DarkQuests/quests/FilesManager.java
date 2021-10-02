package sk.Adreez.DarkQuests.quests;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import sk.Adreez.DarkQuests.Main;

public class FilesManager {

	private Main plugin;
	
	private FileConfiguration QuestsConfiguration = null;
	private File QuestsFile = null;
	
	
	public FilesManager(Main plugin) {
		this.plugin = plugin;
		saveDefault();
	}
	
	public void reloadFiles() {
		if (this.QuestsFile == null) 
			this.QuestsFile = new File(this.plugin.getDataFolder(), "quests.yml");
		
		this.QuestsConfiguration = YamlConfiguration.loadConfiguration(this.QuestsFile);
		
	}
	

	
	public void saveFiles() {
		if (this.QuestsConfiguration == null || this.QuestsConfiguration == null)
			return;
		
		try {
			this.getQuests().save(this.QuestsFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.plugin.getLogger().log(Level.SEVERE, "Could not save quests.yml");
		}
	}
	
	public void saveDefault() {
		if (this.QuestsFile == null)
			this.QuestsFile = new File("plugins/DAQuests/quests.yml");
		
		if (!this.QuestsFile.exists()) {
			this.plugin.saveResource("quests.yml", false);
		}
	}
	
	
	public FileConfiguration getQuests() {
		if (this.QuestsConfiguration == null)
			reloadFiles();
		
		return this.QuestsConfiguration;
	}
	
}
