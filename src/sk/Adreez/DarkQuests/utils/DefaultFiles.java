package sk.Adreez.DarkQuests.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class DefaultFiles {

	
	public static void Settings() {
        
        File config = new File("plugins/DAQuests/config.yml");
        if (!config.exists()) {
          
            try {
              
                config.createNewFile();
              
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("ERROR: Failed to create config.yml!");
            }
          
            FileConfiguration msgfc = YamlConfiguration.loadConfiguration(config);
            
            msgfc.set("MySQL.host", "localhost");
            msgfc.set("MySQL.port", "3306");
            msgfc.set("MySQL.database", "daquests");
            msgfc.set("MySQL.username", "root");
            msgfc.set("MySQL.password", "");
            msgfc.set("MySQL.table", "data");
            msgfc.set("MySQL.useSSL", "false");

            
            msgfc.set("Prefix", "&8[&6&lQuests&8] &8• &r");
            msgfc.set("Messages.no-permissions", "&cSorry but you´re not allowed to do this!");
            
            msgfc.set("Messages.usage.add", "&7Usage: &f/coins add <Nick> <number>");
            
            try {
                msgfc.save(config);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

	public static void test() {
		File questsYML = new File("plugins/DAQuests/quests.yml");
		
		if (!questsYML.exists()) {
			try {
	            
	            questsYML.createNewFile();
	          
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            System.out.println("ERROR: Failed to create config.yml!");
	        }	
		}
		
		FileConfiguration quests = YamlConfiguration.loadConfiguration(questsYML);
		
		quests.options().copyDefaults(true);
		
		//quests.set("1.objective", "destroy");
	
		try {
            quests.save(questsYML);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
