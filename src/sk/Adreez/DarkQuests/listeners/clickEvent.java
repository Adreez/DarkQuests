package sk.Adreez.DarkQuests.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import sk.Adreez.DarkQuests.Main;


public class clickEvent implements Listener {

    
    
    @EventHandler
    public void InvClickEvent(InventoryClickEvent e) {
    	

        Player player = (Player) e.getWhoClicked();
        
        
        if (e.getView().getTitle().equalsIgnoreCase("�9�lQuests")) {
        	if (e.getCurrentItem() == null) {
        		return;
        	}
        	
        	
        	//IF IT�S HOPPER MINECART
        	else if (e.getCurrentItem().getType().equals(Material.HOPPER_MINECART)) {
                if (player != null) {
                	
                	player.sendMessage("Done!");
                	
                	Main.data.addCompletedQuest(e.getWhoClicked().getName().toString());
                	Main.data.setActiveQuest(e.getWhoClicked().getName().toString(), 5);
                	
                	
                	e.setCancelled(true);
                }
                
                
            }
            
        }

    }
	
}
