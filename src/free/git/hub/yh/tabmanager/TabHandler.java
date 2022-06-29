package free.git.hub.yh.tabmanager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import free.git.hub.yh.HubMain;

public class TabHandler implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent playerJoinEvent) {
		Player player = playerJoinEvent.getPlayer();
		
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(HubMain.getInstance(), new Runnable() {
			@Override
			public void run() {
				TabList.sendTablist(player, "\n §B§lHUB \n ", "\n §fLoja: §efree.git.hub.yl/loja \n §fDiscord: §efree.git.hub.yl/discord", (HubMain) HubMain.getInstance(), false);
				
			}
		}, 0L, 20L);
	}
	
	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent playerQuitEvent) {
		Player player = playerQuitEvent.getPlayer();
        
        TabList.sendTablist(player, null, null, (HubMain) HubMain.getInstance(), false);
	}

}
