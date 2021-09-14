package sk.Adreez.DarkQuests;

import java.io.File;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import sk.Adreez.DarkQuests.listeners.*;
import sk.Adreez.DarkQuests.quests.QuestsFileManager;
import sk.Adreez.DarkQuests.quests.QuestsManager;
import sk.Adreez.DarkQuests.utils.*;

public class Main extends JavaPlugin {

	
//*******************************************************\\		
	
	public static JavaPlugin inst;
	public static MySQL SQL;
	public static SQLGetter data;
	public static FileConfiguration config;
	
	public static QuestsFileManager questsyml;
	public static QuestsManager qm;
	
	
//*******************************************************\\	
	
	@Override
	public void onEnable() {
		
		
		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
			new PAPIManager().register();
		} else {
			getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Quests: " + ChatColor.WHITE + "With placeholderAPI this plugin will work better!");
		}
		
		inst = this;
		
		new File("plugins/DAQuests").mkdir();
		DefaultFiles.Settings();
		
		config = YamlConfiguration.loadConfiguration(new File("plugins/DAQuests/config.yml"));
		
		SQL = new MySQL();
		data = new SQLGetter();


		questsyml = new QuestsFileManager(this);
		qm = new QuestsManager(this);
		
/******************************/
//[Try to CONNECT to SQL]	
/******************************/
		
		try {
			SQL.connect();
		} catch (ClassNotFoundException | SQLException e) {
			getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Quests: " + ChatColor.RED + "Database is not connected");
		}
		
		
		if (SQL.isConnected()) {
			getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Quests: " + ChatColor.GREEN + "Database is sucessfuly connected");
			data.createTable();
		}
		
		
/******************************/
//[Commands and Listeners]	
/******************************/	
		
		this.getCommand("quests").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new clickEvent(), this);
		
		if (SQL.isConnected()) {
			Bukkit.getPluginManager().registerEvents(new onJoin(), this);
			Bukkit.getPluginManager().registerEvents(new onDestroy(), this);
			Bukkit.getPluginManager().registerEvents(new onKill(), this);
			Bukkit.getPluginManager().registerEvents(new onPlace(), this);
		}
		
	}
	
	@Override
	public void onDisable() {
		 questsyml.saveQuests();
		 
		 if (SQL.isConnected()) {
			 SQL.disconnect();
		 }
		 
	}
}
