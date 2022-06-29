package free.git.hub.yh.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreHandler {
	
	private Scoreboard scoreboard;
	private Objective objective;

	public ScoreHandler(Player player, String name) {
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		objective = scoreboard.registerNewObjective("score", "dummy");

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(name);

		for (int t = 1; t < 16; t++) {
			@SuppressWarnings("unused")
			Team team = scoreboard.registerNewTeam("line-" + t);
		}
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public String convertOff(int line) {
		if (line == 1) {
			return "§1";
		} else if (line == 2) {
			return "§2";
		} else if (line == 3) {
			return "§3";
		} else if (line == 4) {
			return "§4";
		} else if (line == 5) {
			return "§5";
		} else if (line == 6) {
			return "§6";
		} else if (line == 7) {
			return "§7";
		} else if (line == 8) {
			return "§8";
		} else if (line == 9) {
			return "§9";
		} else if (line == 10) {
			return "§a";
		} else if (line == 11) {
			return "§b";
		} else if (line == 12) {
			return "§c";
		} else if (line == 13) {
			return "§d";
		}
		return "§0";
	}

	@SuppressWarnings("deprecation")
	public void add(String prefix, String suffix, int line) {
		Team t = scoreboard.getTeam("line-" + line);
		PlayerSimulator player = new PlayerSimulator(convertOff(line));
		objective.getScore(player).setScore(line);
		t.addPlayer(player);

		if (prefix.length() > 16) {
			prefix = prefix.substring(0, 16);
		} else if (suffix.length() > 16) {
			suffix = suffix.substring(0, 16);
		}
		t.setPrefix(prefix);
		t.setSuffix(suffix);
	}

	public void updateLine(String prefix, String suffix, int line) {
		Team t = scoreboard.getTeam("line-" + line);
		if (prefix.length() > 16) {
			prefix = prefix.substring(0, 16);
		} else if (suffix.length() > 16) {
			suffix = suffix.substring(0, 16);
		}
		t.setPrefix(prefix);
		t.setSuffix(suffix);
	}
}