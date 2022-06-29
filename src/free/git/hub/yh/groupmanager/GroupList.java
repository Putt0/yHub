package free.git.hub.yh.groupmanager;

public enum GroupList {
	
	ADMIN(0, "A", "Admin", "§4", "group.admin"),
	MODPLUS(1, "B", "Mod+", "§5", "group.modplus"),
	MODGC(2, "C", "ModGC", "§5", "group.modgc"),
	MOD(3, "D", "Mod", "§5", "group.mod"),
	TRIAL(4, "E", "Trial", "§5", "group.trial"),
	BUILDER(5, "F", "Builder", "§2", "group.builder"),
	YTPLUS(6, "G", "YT+", "§3", "group.ytplus"),
	YT(7, "H", "YT", "§b", "group.yt"),
	STREAMER(8, "I", "Streamer", "§5", "group.streamer"),
	BETA(9, "J", "Beta", "§1", "group.beta"),
	SINGLE(10, "K", "Single", "§6", "group.single"),
	SAFIRA(11, "L", "Safira", "§b", "group.safira"),
	MEMBRO(12, "M", "Membro", "§7", "group.membro");
	
	private Integer id;
	private String position, name, color, permission; 
	
	private GroupList(Integer id, String position, String name, String color, String permission) {
		this.id = id;
		this.position = position;
		this.name = name;
		this.color = color;
		this.permission = permission;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getPermission() {
		return permission;
	}
}
