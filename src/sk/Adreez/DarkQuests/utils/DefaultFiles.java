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
            msgfc.set("Messages.usage.set", "&7Usage: &f/coins set <Nick> <number>");
            msgfc.set("Messages.usage.remove", "&7Usage: &f/coins remove <Nick> <number>");
            msgfc.set("Messages.usage.check", "&7Usage: &f/coins check <Nick>");
            
            try {
                msgfc.save(config);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

	public static void test() {
		File testYML = new File("plugins/DAQuests/test.yml");
		
		if (!testYML.exists()) {
			try {
	            
	            testYML.createNewFile();
	          
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            System.out.println("ERROR: Failed to create config.yml!");
	        }	
		}
		
		FileConfiguration ttt = YamlConfiguration.loadConfiguration(testYML);
	
		try {
            ttt.save(testYML);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
