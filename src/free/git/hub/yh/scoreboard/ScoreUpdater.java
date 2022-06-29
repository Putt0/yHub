package free.git.hub.yh.scoreboard;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import free.git.hub.yh.HubMain;
import free.git.hub.yh.groupmanager.GroupRegexPermissions;

public class ScoreUpdater {
	
	public static ArrayList<Player> hasScore = new ArrayList<Player>();

	public static HashMap<Player,  ScoreHandler> sscore = new HashMap<>();

	public static void updateAllScoreboards() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(HubMain.getInstance(), new Runnable() {
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					updateScoreboardLobby(player);
				}
			}
		}, 0, 3L);
	}
	
	/*
	 * SCORE FIX || HUB
	 */
		
	public static void updateScoreboardLobby(Player player) {
		if (hasScore.contains(player)) {

			ScoreHandler sb = sscore.get(player);

			player.getScoreboard().getObjective("score").setDisplayName("§b§lHUB");
			
			sb.updateLine(" §fRank: ", "" + GroupRegexPermissions.getGroup(player), 6);
			sb.updateLine(" §fPlayers: ", "§a" + Bukkit.getOnlinePlayers().size(), 3);

		}
	}
	
	/*
	 * SCORE EDIT || HUB
	 */

	public static void createScoreLobby(Player player) {
		if (hasScore.contains(player)) {
			ScoreHandler score = new ScoreHandler(player, "§b§lHUB");

			score.add("", "", 7);
			score.add(" §fRank: ", "" + GroupRegexPermissions.getGroup(player), 6);
			score.add("", "", 5);
			score.add(" §fHub: ", "§a#1", 4);
			score.add(" §fPlayers: ", "§a" + Bukkit.getOnlinePlayers().size(), 3);
			score.add("", "", 2);
			score.add("  §afree.git.hub", "§a.yl", 1);

			sscore.put(player, score);
			player.setScoreboard(score.getScoreboard());
		}
	}
}