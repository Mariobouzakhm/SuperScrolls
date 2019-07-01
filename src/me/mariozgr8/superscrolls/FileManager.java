package me.mariozgr8.superscrolls;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FileManager {
	private String configVersion;
	private String messageConfigVersion;
	
	//Settings Concerning the scrolls retrieved from the config.yml file
	private String noPermLore;
	private String scrollMaterial;
	private String scrollLore;
	private String scrollInvName;
	private String scrollInfoInvName;
	
	private String blockBrokenScroll;
	private String oresMinedScroll;
	private String damageDealtScroll;
	private String mobsKilledScroll;
	private String arrowShotScroll;
	private String logsBrokenScroll;
	private String playersKilledScroll;
	
	//Settings Concerning the messages sent to players retrieved from the messages.yml file !
	private String prefix;
	private String errorMessage;
	private String noperms;
	private String wrongargs;
	private String playerOnly;
//	private String playerOffline;
	
	
	public void setup(SettingsManager p) {
		configVersion = p.getConfig().getString("config-version");
		messageConfigVersion = p.getMessageConfig().getString("config-version");
		
		noPermLore = p.getConfig().getString("no-perm-lore");
		scrollMaterial = p.getConfig().getString("scroll-material");
		scrollLore = p.getConfig().getString("scroll-lore");
		scrollInvName = p.getConfig().getString("scroll-inventory-name");
		scrollInfoInvName = p.getConfig().getString("scroll-info-inventory-name");
		
		blockBrokenScroll = p.getConfig().getString("scroll-blockBroken-name");
		oresMinedScroll = p.getConfig().getString("scroll-oresMined-name");
		damageDealtScroll = p.getConfig().getString("scroll-damageDealt-name");
		mobsKilledScroll = p.getConfig().getString("scroll-mobsKilled-name");
		arrowShotScroll = p.getConfig().getString("scroll-arrowshot-name");
		logsBrokenScroll = p.getConfig().getString("scroll-logsbroken-name");
		playersKilledScroll = p.getConfig().getString("scroll-playerskilled-name");
	
		prefix = p.getMessageConfig().getString("messages.prefix");
		errorMessage = p.getMessageConfig().getString("messages.error-message");
		noperms = p.getMessageConfig().getString("messages.noperms");
		wrongargs = p.getMessageConfig().getString("messages.wrongargs");
		playerOnly = p.getMessageConfig().getString("messages.playeronly");
//		playerOffline = p.getMessageConfig().getString("messages.playeroffline");
	}
	public String getScrollInvName() {
		return changeColor(scrollInvName);
	}
	public String getScrollInfoInvName() {
		return changeColor(scrollInfoInvName);
	}
	
	
	
	public String getConfigVersion() {
		return configVersion;
	}
	public String getMessageConfigVersion() {
		return messageConfigVersion;
	}
	
	public String getScrollMaterial() {
		return scrollMaterial;
	}
	public String getNoPermLore() {
		return noPermLore;
	}
	public String getScrollLore() {
		return scrollLore;
	}
	
	public String getBlockBrokenScroll() {
		return blockBrokenScroll;
	}
	public String getOresMinedScroll() {
		return oresMinedScroll;
	}
	public String getDamageDealtScroll() {
		return damageDealtScroll;
	}
	public String getMobsKilledScroll() {
		return mobsKilledScroll;
	}
	public String getArrowsShotScroll() {
		return arrowShotScroll;
	}
	public String getLogsBrokenScroll() {
		return logsBrokenScroll;
	}
	public String getPlayerskilledScroll() {
	    return playersKilledScroll;
    }
	public String getPrefix() {
		return prefix;
	}
	public String getNoperms() {
		return noperms;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getWrongargs() {
		return wrongargs;
	}
	public String getPlayerOnly() {
		return playerOnly;
	}
//	public String getPlayerOffline() {
//		return playerOffline;
//	}
	
	public String changeColor(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	public void sendMessageToPlayer(CommandSender sender, String message) {
		sender.sendMessage(this.changeColor(this.prefix+" "+message));
	}
	public void sendMessageToPlayer(Player p, String message) {
		p.sendMessage(this.changeColor(this.prefix+" "+message));
	}
	
	public void sendHelpMessage(CommandSender s) {
		this.sendMessageToPlayer(s, "&6Commands: ");
		this.sendMessageToPlayer(s, " &6- /sscroll help : Show this message.");
		this.sendMessageToPlayer(s, " &6- /sscroll info : Open the GUI that gives informations about each scroll.");
		this.sendMessageToPlayer(s, " &6- /sscroll : Open the GUI to get scrolls.");
	}
}
