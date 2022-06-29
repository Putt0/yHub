package free.git.hub.yh.groupmanager;

import org.bukkit.entity.Player;

public class GroupRegexPermissions {
	
	public static String getGroup(Player player) {
		if (player.hasPermission(GroupList.ADMIN.getPermission())) {
			return GroupList.ADMIN.getColor() + GroupList.ADMIN.getName();
		} else if (player.hasPermission(GroupList.MODPLUS.getPermission())) {
			return GroupList.MODPLUS.getColor() + GroupList.MODPLUS.getName();
		} else if (player.hasPermission(GroupList.MODGC.getPermission())) {
			return GroupList.MODGC.getColor() + GroupList.MODGC.getName(); 
		} else if (player.hasPermission(GroupList.MOD.getPermission())) {
			return GroupList.MOD.getColor() + GroupList.MOD.getName(); 
		} else if (player.hasPermission(GroupList.TRIAL.getPermission())) {
			return GroupList.TRIAL.getColor() + GroupList.TRIAL.getName(); 
		} else if (player.hasPermission(GroupList.BUILDER.getPermission())) {
			return GroupList.BUILDER.getColor() + GroupList.BUILDER.getName(); 
		} else if (player.hasPermission(GroupList.YTPLUS.getPermission())) {
			return GroupList.YTPLUS.getColor() + GroupList.YTPLUS.getName(); 
		} else if (player.hasPermission(GroupList.YT.getPermission())) {
			return GroupList.YT.getColor() + GroupList.YT.getName(); 
		} else if (player.hasPermission(GroupList.STREAMER.getPermission())) {
			return GroupList.STREAMER.getColor() + GroupList.STREAMER.getName(); 
		} else if (player.hasPermission(GroupList.BETA.getPermission())) {
			return GroupList.BETA.getColor() + GroupList.BETA.getName(); 
		} else if (player.hasPermission(GroupList.SINGLE.getPermission())) {
			return GroupList.SINGLE.getColor() + GroupList.SINGLE.getName(); 
		} else if (player.hasPermission(GroupList.SAFIRA.getPermission())) {
			return GroupList.SAFIRA.getColor() + GroupList.SAFIRA.getName(); 
		} 
		return GroupList.MEMBRO.getColor() + GroupList.MEMBRO.getName();
	}
}

