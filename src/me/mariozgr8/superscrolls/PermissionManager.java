package me.mariozgr8.superscrolls;

import org.bukkit.entity.Player;

public class PermissionManager {
	private FileManager files = SuperScrolls.getMain().getFiles();
	
	public String guiPerm = "superscrolls.open";
	public String infoPerm = "superscrolls.info";
	public String helpPerm = "superscrolls.help";
	
	public String blocksBrokenPerm = "superscrolls.apply.blocksbroken";
	public String oresMinedPerm = "superscrolls.apply.oresmined";
	public String damageDealtPerm = "superscrolls.apply.damagedealt";
	public String mobsKilledPerm = "superscrolls.apply.mobskilled";
	public String arrowsShotPerm = "superscrolls.apply.arrowsshot";
	public String logsBrokenPerm = "superscrolls.apply.logsbroken";
	
	public boolean hasPermission(Player p, String perm) {
		return p.hasPermission(perm);
	}
	public String permLore(Player p, String perm) {
		return (p.hasPermission(perm)) ? " " : this.files.getNoPermLore();
	}
	
}
