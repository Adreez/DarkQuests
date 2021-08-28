package sk.Adreez.DarkQuests.utils;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import sk.Adreez.DarkQuests.Main;


public class Commands implements CommandExecutor {
	
	public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] label) {
		
		if (label.length == 0) {
			if (sender instanceof Player) {
				//ActiveQuest HERE
				int p = Main.data.getProgress(sender.getName());
				sender.sendMessage("You´re progress: " + p);
			} else {
				sender.sendMessage("Help message");
			}
		}
		
/*
 * 
 * quests SET nick num
 * 
 */		
		else if (label[0].equalsIgnoreCase("set")) {
			
//			String usage = CoinsMain.msgfc.getString("Messages.usage.add").replace("&", "§");
			
			
			if (label.length == 1) {
			
				if (sender.hasPermission("coins.admin")) {
				
					sender.sendMessage("Usage");
				
				} else {
				
					sender.sendMessage("NoPerms");
				
				}
			
			}
			
			else if (label.length == 2) {
				
				if (sender.hasPermission("coins.admin")) {
				
					if (Bukkit.getPlayer(label[1]) != null) {
						
						sender.sendMessage("Usage");
					
					} else {
						
						sender.sendMessage("Player not exist");
					
					}
				
				} else {
					
					sender.sendMessage("NoPerms");
				
				}
			
			}
//			
			else if (label.length == 3) {
				
				if (sender.hasPermission("coins.admin")) {
				
					if (Bukkit.getServer().getPlayer(label[1]) != null) {
				
						if (isInt(label[2])) {
							
					
							Player targetplayer = Bukkit.getServer().getPlayer(label[1]);
							int questTOset = Integer.parseInt(label[2]);
							
							Main.data.setActiveQuest(targetplayer.getName().toString(), questTOset);
							
							sender.sendMessage("Quest " + questTOset + "Has been set to player " + targetplayer.getName());
							
							
							
						} else {
						
							sender.sendMessage("Number not exist");
						
						}
					
					} else {
					
						sender.sendMessage("Player doesn´t exist");
					
					}
				
				} else {
					
					sender.sendMessage("NoPerms");
				
				}
			
			}
			
			else if (label.length >= 4) {
				
				if (sender.hasPermission("coins.admin")) {
				
					sender.sendMessage("Usage");
				
				} else {
					
					sender.sendMessage("NoPerms");
				
				}
			}
		}
		return false;
	}

}
