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
import free.git.hub.yh.groupmanager.GroupRegexPermissions;
import free.git.hub.yh.items.ItemBuilder;

public class AccountInventorys implements Listener {
	
	public static void InventoryAccount(Player player) {
		Inventory inventoryaccount = Bukkit.createInventory(player, 27, "§aYour profile");
		Bukkit.getScheduler().scheduleSyncRepeatingTask(HubMain.getInstance(), () -> {
			inventoryaccount.setItem(10, ItemBuilder.newHeadfooter("§a" + player.getName(), player.getName(), new String[] {"", "§fRank: " + GroupRegexPermissions.getGroup(player), "", "§fXp: §a0", "§fLeague: - Unranked"}));
			inventoryaccount.setItem(12, ItemBuilder.newItem(Material.FEATHER, "§eSkyWars", new String[] {"", "§fSolo:", "§fKilled: §a0", "§fDeaths: §c0", "§fStreak: §e0", "", "§fDuo:", "§fKilled: §a0", "§fDeaths: §c0"}, 1, (byte) 0));
			inventoryaccount.setItem(13, ItemBuilder.newItem(Material.DIAMOND_CHESTPLATE, "§eDuels", new String[] {"", "§fArena:", "§fKilled: §a0", "§fDeaths: §c0", "§fStreak: §e0", "", "§fFps:", "§fKilled: §a0", "§fDeaths: §c0"}, 1, (byte) 0));
			inventoryaccount.setItem(14, ItemBuilder.newItem(Material.MUSHROOM_SOUP, "§eHG", new String[] {"", "§fTournaments:", "§fKilled: §a0", "§fDeaths: §c0", "§fStreak: §e0"}, 1, (byte) 0));
		}, 0, 20);
		player.openInventory(inventoryaccount);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent inventoryClickEvent) {
		Player player = (Player)inventoryClickEvent.getWhoClicked();
		if ((inventoryClickEvent.getInventory().getTitle().equalsIgnoreCase("§aYour profile")) && (inventoryClickEvent.getCurrentItem() != null) && (inventoryClickEvent.getCurrentItem().getTypeId() != 0)) {
			inventoryClickEvent.setCancelled(true);
			if (inventoryClickEvent.getCurrentItem().getType() == Material.SKULL_ITEM) {
				inventoryClickEvent.setCancelled(true);
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				return;
			} else if (inventoryClickEvent.getCurrentItem().getType() == Material.FEATHER) {
				inventoryClickEvent.setCancelled(true);
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				return;
			} else if (inventoryClickEvent.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				inventoryClickEvent.setCancelled(true);
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				return;
			} else if (inventoryClickEvent.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				inventoryClickEvent.setCancelled(true);
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				return;
			}
		}
	}
}