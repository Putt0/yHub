package free.git.hub.yh.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import free.git.hub.yh.HubMain;
import free.git.hub.yh.items.ItemBuilder;

public class ServerInventory implements Listener {
	
	public static void InventoryServer(Player player) {
		Inventory inventoryserver = Bukkit.createInventory(player, 27, "§aSelect a server.");
		Bukkit.getScheduler().scheduleSyncRepeatingTask(HubMain.getInstance(), () -> {
			inventoryserver.setItem(11, ItemBuilder.newItem(Material.DIAMOND_CHESTPLATE, "§eDuels", new String[] {"§7..."}, 1, (byte) 0));
			inventoryserver.setItem(13, ItemBuilder.newItem(Material.MUSHROOM_SOUP, "§eHG", new String[] {"§7..."}, 1, (byte) 0));
			inventoryserver.setItem(15, ItemBuilder.newItem(Material.FEATHER, "§eSkyWars", new String[] {"§7..."}, 1, (byte) 0));
		}, 0, 20);
		player.openInventory(inventoryserver);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent inventoryClickEvent) {
		Player player = (Player)inventoryClickEvent.getWhoClicked();
		if ((inventoryClickEvent.getInventory().getTitle().equalsIgnoreCase("§aSelect a server.")) && (inventoryClickEvent.getCurrentItem() != null) && (inventoryClickEvent.getCurrentItem().getTypeId() != 0)) {
			inventoryClickEvent.setCancelled(true);
			if (inventoryClickEvent.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				inventoryClickEvent.setCancelled(true);
				player.closeInventory();
				player.sendMessage("§2§lPLAY §aConnecting...");
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				return;
			} else if (inventoryClickEvent.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				inventoryClickEvent.setCancelled(true);
				player.closeInventory();
				player.sendMessage("§4§lPLAY §cThis server is unavailable.");
				player.playSound(player.getLocation(), Sound.VILLAGER_NO,  2.0F, 1.0F);
				return;
			} else if (inventoryClickEvent.getCurrentItem().getType() == Material.FEATHER) {
				inventoryClickEvent.setCancelled(true);
				player.closeInventory();
				player.sendMessage("§4§lPLAY §cThis server is unavailable.");
				player.playSound(player.getLocation(), Sound.VILLAGER_NO,  2.0F, 1.0F);
				return;
			}
		}
	}
}
