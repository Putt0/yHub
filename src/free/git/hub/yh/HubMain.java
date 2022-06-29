package free.git.hub.yh;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class HubMain extends JavaPlugin {

	private static Plugin instance;
	
    public static Plugin getInstance() {
        return instance;
    }
	
	@Override
	public void onLoad() {
		instance = this;
		System.out.println("[yHub] Loading...");
	}
	
	@Override
	public void onEnable() {
		HubCommon.registerListener();
		HubCommon.registerCommand();
		HubCommon.registerInventory();
		HubCommon.registerRunnable();
		System.out.println("[yHub] Enabled.");
	}
	
	@Override
	public void onDisable() {
		instance = null;
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.kickPlayer("§cThis server is unavailable.");
		}
		
		System.out.println("[yHub] Disabled.");
	}
}
