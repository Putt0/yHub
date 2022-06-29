package free.git.hub.yh;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import free.git.hub.yh.command.GamemodeCommand;
import free.git.hub.yh.inventorys.AccountInventorys;
import free.git.hub.yh.inventorys.ServerInventory;
import free.git.hub.yh.listeners.ServerListeners;
import free.git.hub.yh.scoreboard.ScoreUpdater;
import free.git.hub.yh.tabmanager.TabHandler;

public class HubCommon {
	
	/**
	 * Register || Listener's
	 */
	
	public static void registerListener() {
		PluginManager Listeners = Bukkit.getPluginManager();
		Listeners.registerEvents(new ServerListeners(), HubMain.getInstance());
		Listeners.registerEvents(new TabHandler(), HubMain.getInstance());
	}
	
	
	/*
	 * Register || Command's
	 */
	
	public static void registerCommand() {
		Plugin Commands = HubMain.getInstance();
		((JavaPlugin) Commands).getCommand("gm").setExecutor(new GamemodeCommand());
	}
	
	/**
	 * Register || Inventory's
	 */
	
	public static void registerInventory() {
		PluginManager Inventorys = Bukkit.getPluginManager();
		Inventorys.registerEvents(new ServerInventory(), HubMain.getInstance());
		Inventorys.registerEvents(new AccountInventorys(), HubMain.getInstance());
	}
	
	/**
	 * Register || Runnable's
	 */
	
	public static void registerRunnable() {
		ScoreUpdater.updateAllScoreboards();		
	}
}
