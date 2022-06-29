package free.git.hub.yh.command;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§4§lCOMMAND §cCommand only available in game.");
			return true;
		}
		
		Player player = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (!player.hasPermission("cmd.gm")) {
				player.sendMessage("§4§lGM §cYou don't have permission.");
				player.playSound(player.getLocation(), Sound.VILLAGER_NO,  2.0F, 1.0F);
			} else if (args.length == 0) {
				player.sendMessage("§2§lGM §cUse: /gm <0> <1> <2> ou <3>");
				player.playSound(player.getLocation(), Sound.NOTE_PLING,  2.0F, 1.0F);
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("0")) {
					player.sendMessage("§2§lGM §aYou got into the mode: §eSurvival.");
					player.setGameMode(GameMode.SURVIVAL);
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				} else if (args[0].equalsIgnoreCase("1")) {
					player.sendMessage("§2§lGM §aYou got into the mode: §eCreative.");
					player.setGameMode(GameMode.CREATIVE);
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				} else if (args[0].equalsIgnoreCase("2")) {
					player.sendMessage("§2§lGM §aYou got into the mode: §eAdventure.");
					player.setGameMode(GameMode.ADVENTURE);
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				} else if (args[0].equalsIgnoreCase("3")) {
					player.sendMessage("§2§lGM §aYou got into the mode: §eSpectator.");
					player.setGameMode(GameMode.SPECTATOR);
					player.playSound(player.getLocation(), Sound.LEVEL_UP,  2.0F, 1.0F);
				}
			}
		}
		return false;
	}
}