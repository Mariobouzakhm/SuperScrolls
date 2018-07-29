package me.mariozgr8.superscrolls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {
	private static SettingsManager settings = new SettingsManager();
	private SettingsManager() { }
	
	public static SettingsManager getInstance() {
		return settings;
	}
	
	private File file;
	private FileConfiguration config;
	
	private File messageFile;
	private FileConfiguration messageConfig;
	
	public void setup(Plugin p) {
		if(!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		
		file = new File(p.getDataFolder(), "config.yml");
		if(!file.exists()) {
			try {
				File en = new File(p.getDataFolder(), "/config.yml");
				InputStream E = getClass().getResourceAsStream("/config.yml");
				copyFile(E, en);
			} 
			catch (Exception e) {
				Bukkit.getServer().getLogger().severe("Could not create config.yml !");
			}
		}
		config = YamlConfiguration.loadConfiguration(file);
		
		messageFile = new File(p.getDataFolder(), "messages.yml");
		if(!messageFile.exists()) {
			try {
				File en = new File(p.getDataFolder(), "/messages.yml");
				InputStream E = getClass().getResourceAsStream("/messages.yml");
				copyFile(E, en);
			}
			catch(Exception e) {
				Bukkit.getServer().getLogger().severe("Could nor create a messages.yml file !");
			}
		}
		messageConfig = YamlConfiguration.loadConfiguration(messageFile);
	}
	
	
	public static void copyFile(InputStream in, File out) throws Exception { // https://bukkit.org/threads/extracting-file-from-jar.16962/
		InputStream fis = in;
		FileOutputStream fos = new FileOutputStream(out);
		try {
			byte[] buf = new byte[1024];
			int i = 0;
			while((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			if(fis != null) {
				fis.close();
			}
			if(fos != null) {
				fos.close();
			}
		}
	}
	
	
	public FileConfiguration getConfig() {
		return config;
	}
	public void saveConfig() {
		try {
			config.save(file);
		}
		catch(IOException e) {
			Bukkit.getServer().getLogger().severe("Could not save config.yml !");
		}
	}
	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getMessageConfig() {
		return messageConfig;
	}
	public void saveMessageConfig() {
		try {
			messageConfig.save(messageFile);
		}
		catch(IOException e) {
			Bukkit.getServer().getLogger().severe("Could not save messages.yml !");
		}
	}
	public void reloadMessageConfig() {
		messageConfig = YamlConfiguration.loadConfiguration(messageFile);
	}
	
	
}
