package me.mariozgr8.superscrolls;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mariozgr8.superscrolls.Handlers.ScrollHandler;

public class SScrollCommand implements CommandExecutor {
	private FileManager files = SuperScrolls.getMain().getFiles();
	private ScrollHandler manager = SuperScrolls.getMain().getManager();
	private PermissionManager perms = SuperScrolls.getMain().getPerms();
	
	
	public SScrollCommand(SuperScrolls ss) {
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			this.files.sendMessageToPlayer(sender, this.files.getPlayerOnly());
			return true;
		}
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("sscroll")){
			if(args.length >= 2) {
				this.files.sendMessageToPlayer(p, this.files.getWrongargs());
				return true;
			}
			if(args.length == 0) {
				if(this.perms.hasPermission(p, this.perms.guiPerm))
				{
					if(p.getInventory().getItemInMainHand().getType() == Material.AIR)
					{
						this.files.sendMessageToPlayer(p, "&6Please hold an item to open the GUI");
						return true;
					}
					p.openInventory(this.manager.getScrollInv(p));
					return true;
				}
				else {
					this.files.sendMessageToPlayer(p, this.files.getNoperms());
				}
			}
			String subCommand = args[0];
			if(subCommand.equals("info")) {
				if(this.perms.hasPermission(p, this.perms.infoPerm))
				{
					p.openInventory(this.manager.getScrollInfoInv());
					return true;
				}
				else {
					this.files.sendMessageToPlayer(p, this.files.getNoperms());
				}
			}
			else if(subCommand.equals("help")) {
				if(this.perms.hasPermission(p, this.perms.helpPerm))
				{
					this.files.sendHelpMessage(p);
					return true;
				}
				else {
					this.files.sendMessageToPlayer(p, this.files.getNoperms());
				}
			}
			else {
				this.files.sendMessageToPlayer(p, this.files.getWrongargs());
				return true;
			}
		}
		return false;
	}
}
