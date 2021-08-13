package sk.Adreez.DarkQuests;

import java.io.File;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import sk.Adreez.DarkQuests.listeners.*;
import sk.Adreez.DarkQuests.utils.*;

public class Main extends JavaPlugin {

	
	public static JavaPlugin inst;
	public static MySQL SQL;
	public static SQLGetter data;
	public static FileConfiguration config;
	
	@Override
	public void onEnable() {
		
		inst = this;
		
		new File("plugins/DAQuests").mkdir();
		DefaultFiles.Settings();
		DefaultFiles.test();
		
		
		config = YamlConfiguration.loadConfiguration(new File("plugins/DAQuests/config.yml")); //ReloadFile();
		
		SQL = new MySQL();
		data = new SQLGetter();
		
		try {
			SQL.connect();
		} catch (ClassNotFoundException | SQLException e) {
			getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Quests: " + ChatColor.RED + "Database is not connected");
		}
		
		
		if (SQL.isConnected()) {
			getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Quests: " + ChatColor.GREEN + "Database is sucessfuly connected");
			data.createTable();
		}
		
		
		this.getCommand("quests").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new clickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new onJoin(), this);
	}
	
	@Override
	public void onDisable() {
		 if (SQL.isConnected()) {
			 
		 }
	}
}
