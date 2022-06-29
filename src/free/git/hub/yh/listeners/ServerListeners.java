package free.git.hub.yh.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import free.git.hub.yh.inventorys.AccountInventorys;
import free.git.hub.yh.inventorys.ServerInventory;
import free.git.hub.yh.items.ItemBuilder;
import free.git.hub.yh.scoreboard.ScoreUpdater;

public class ServerListeners implements Listener {
	
	/*
	 * Register || Join
	 */
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent playerJoinEvent) {
		playerJoinEvent.setJoinMessage(null);
		
		Player player = playerJoinEvent.getPlayer();
		
		ScoreUpdater.hasScore.add(player);
		ScoreUpdater.createScoreLobby(player);
		
		ItemBuilder.ItemsOfLobby(player);
		player.teleport(Bukkit.getWorld("world").getSpawnLocation());
		player.setGameMode(GameMode.ADVENTURE);
		
		for (int clearchat = 1; clearchat < 100; clearchat++) {
			playerJoinEvent.getPlayer().sendMessage("");
		}
		player.sendMessage("§B§lHUB");
		player.sendMessage("");
		player.sendMessage("§fHi §a" + player.getName() + " §fWelcome to the server");
		player.sendMessage("§fCome test the game mode: §eDuels §f(§1Beta§f)");
		player.sendMessage("");
		player.sendMessage("§4§lWARN §fThe server is in the testing phase, and may contain bugs.");
		player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
		
	}
	
	/*
	 * Register || Leave
	 */
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent playerQuitEvent) {
		playerQuitEvent.setQuitMessage(null);
	}
	
	/*
	 * Register || Click in item hand
	 */
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent playerInteractEvent) {
		Player player = playerInteractEvent.getPlayer();
		
		if (player.getItemInHand().getType() == Material.COMPASS) {
			if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR) {
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				ServerInventory.InventoryServer(player);
			} else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				ServerInventory.InventoryServer(player);
			}
		} else if (player.getItemInHand().getType() == Material.SKULL_ITEM) {
			if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR) {
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				AccountInventorys.InventoryAccount(player);
			} else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
				player.playSound(player.getLocation(), Sound.CLICK,  2.0F, 1.0F);
				AccountInventorys.InventoryAccount(player);
			}
		} 
	}
	
	/*
	 * Register || Cancel item drops
	 */
	
	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent playerDropItemEvent) {
		playerDropItemEvent.setCancelled(true);
	}
}
