package me.mariozgr8.superscrolls;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.mariozgr8.superscrolls.Handlers.ScrollHandler;
import me.mariozgr8.superscrolls.Listeners.ClickListener;
import me.mariozgr8.superscrolls.Listeners.ScrollListener;

public class SuperScrolls extends JavaPlugin
{
	private static SuperScrolls main;
	public static SuperScrolls getMain() {
		return main;
	}
	
	private SettingsManager settings;
	private FileManager files;
	private PermissionManager perms;
	private ScrollHandler manager;
	
	private String version = "1.0";
	
	
	public void onEnable() {
		main = this;
		settings = SettingsManager.getInstance();
		files = new FileManager();
		perms = new PermissionManager();
		manager = new ScrollHandler();
	
		settings.setup(this);
		files.setup(settings);
		
		registerCommands();
		registerEvents();
		
		ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();
		sender.sendMessage("SuperScolls Enabled !");
		sender.sendMessage("Version: "+version);
		
		
	}
	public void onDisable() {
		ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();
		sender.sendMessage("SuperScolls Disabled !");
		sender.sendMessage("Version: "+version);
	}
	public void registerCommands() {
		this.getCommand("sscroll").setExecutor(new SScrollCommand(this));
	}
	public void registerEvents() {
		Bukkit.getServer().getPluginManager().registerEvents(new ClickListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ScrollListener(), this);
	}
	
	
	public SettingsManager getSettings() {
		return settings;
	}
	public FileManager getFiles() {
		return files;
	}
	public ScrollHandler getManager() {
		return manager;
	}
	public PermissionManager getPerms() {
		return perms;
	}
}
