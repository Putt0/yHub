package free.git.hub.yh.items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder implements Listener {
	
	public static ItemStack newItem(Material mat, String name, String[] desc) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemk = item.getItemMeta();
		itemk.setDisplayName(name);
		itemk.setLore(Arrays.asList(desc));
		item.setItemMeta(itemk);
		return item;
	}
	
	public static ItemStack newItem(Material mat, String name, String[] desc, int qt, byte bt) {
		ItemStack item = new ItemStack(mat, qt, (byte) bt);
		ItemMeta itemk = item.getItemMeta();
		itemk.setDisplayName(name);
		itemk.setLore(Arrays.asList(desc));
		item.setItemMeta(itemk);
		return item;
	}
	
	public static ItemStack newItem(Material mat, String name, int qt, byte bt) {
		ItemStack item = new ItemStack(mat, qt, (byte) bt);
		ItemMeta itemk = item.getItemMeta();
		itemk.setDisplayName(name);
		item.setItemMeta(itemk);
		return item;
	}
	
	public static ItemStack newHeadfooter(String name, String nameplayer, String[] desc) {
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(397));
		SkullMeta sm = (SkullMeta) item.getItemMeta();
		item.setDurability((short) 3);
		sm.hasOwner();
		sm.setOwner(nameplayer);
		sm.setDisplayName(name);
		sm.setLore(Arrays.asList(desc));
		item.setItemMeta(sm);
		return item;
	}
	
	public static ItemStack newHead(String name, String nameplayer) {
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(397));
		SkullMeta sm = (SkullMeta) item.getItemMeta();
		item.setDurability((short) 3);
		sm.hasOwner();
		sm.setOwner(nameplayer);
		sm.setDisplayName(name);
		item.setItemMeta(sm);
		return item;
	}

	public static void ItemsOfLobby(Player player) {
		player.getInventory().clear();
		player.getInventory().setItem(3, newItem(Material.COMPASS, "§aSelect a server §f(Click)", new String[] {}, 1, (byte) 0));
		player.getInventory().setItem(5, newHead("§aManage Profile §f(Click)", player.getName()));
		player.updateInventory();
	}
}



