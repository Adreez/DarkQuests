package sk.Adreez.DarkQuests.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] label) {
		
		if (sender instanceof Player) {
			if (label.length == 0) {

				Player player = (Player) sender;
				
				Inventory gui = Bukkit.createInventory(player, 54, "§9§lQuests");
				
				ItemStack norank = new ItemStack(Material.HOPPER_MINECART);
				
				ItemMeta norank_meta = norank.getItemMeta();
				norank_meta.setDisplayName("§aChop 10 oak wood with any tool");
				
				ArrayList<String> norank_lore = new ArrayList<>();
				norank_lore.add("§7Current reward:");
				norank_lore.add("§7+ 5 xp");
				norank_lore.add("§r");
				norank_lore.add("§8With §aVIP §8you can get:");
				norank_lore.add("§8+ 5 xp more");
				
				norank_meta.setLore(norank_lore);
				norank.setItemMeta(norank_meta);
			
				
				gui.setItem(11, norank);
				
				
				player.openInventory(gui);
				
				
			} else {
				sender.sendMessage("Usage");
			}
			
		} else {
			sender.sendMessage("You need to be player for this command!");
		}
		
		
		return false;
	}

}
