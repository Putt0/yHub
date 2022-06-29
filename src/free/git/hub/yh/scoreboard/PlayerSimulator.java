package free.git.hub.yh.scoreboard;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PlayerSimulator implements OfflinePlayer {

	private String name;
	private UUID id;

	public void setName(String name) {
		this.name = name;
	}

	public PlayerSimulator(String name) {
		this.name = name;
		this.id = UUID.nameUUIDFromBytes(name.getBytes());
	}

	public PlayerSimulator(String name, UUID id) {
		this(name);
		this.setId(id);
	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean arg) {

	}

	@Override
	public Map<String, Object> serialize() {
		return null;
	}

	@Override
	public Location getBedSpawnLocation() {
		return null;
	}

	@Override
	public long getFirstPlayed() {
		return 0;
	}

	@Override
	public long getLastPlayed() {
		return 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Player getPlayer() {
		Player Gamer = Bukkit.getPlayer(id);
		return Gamer == null ? Bukkit.getPlayer(name) : Gamer;
	}

	@Override
	public UUID getUniqueId() {
		return id;
	}

	@Override
	public boolean hasPlayedBefore() {
		return true;
	}

	@Override
	public boolean isBanned() {
		return false;
	}

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public boolean isWhitelisted() {
		return false;
	}

	@Override
	public void setBanned(boolean arg) {

	}

	@Override
	public void setWhitelisted(boolean arg) {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}