package me.mariozgr8.superscrolls.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mariozgr8.superscrolls.FileManager;
import me.mariozgr8.superscrolls.PermissionManager;
import me.mariozgr8.superscrolls.SettingsManager;
import me.mariozgr8.superscrolls.SuperScrolls;

public class ScrollHandler {
	
	private SettingsManager settings = SuperScrolls.getMain().getSettings();
	private FileManager files = SuperScrolls.getMain().getFiles();
	private PermissionManager perms = SuperScrolls.getMain().getPerms();
	
	@SuppressWarnings("deprecation")
	public Material getScrollMaterial() {
		String result = this.settings.getConfig().getString("scroll-material");
		if(result.contains(":")) {
			int index = result.indexOf(":");
			String startOfString = result.substring(0,index);
			return Material.getMaterial(Integer.valueOf(startOfString));}
		else {
			return Material.getMaterial(Integer.valueOf(result));
		}
	}
	public byte getScrollDataValue() {
		String result = this.settings.getConfig().getString("scroll-material");
		if(result.contains(":")){
			int index = result.indexOf(":");
			String endOfString = result.substring(index + 1);
			return Byte.valueOf(endOfString);
		}
		else {
			return 0;
		}
	}
	public void incrementBlockBroken(ItemStack i) {
		ItemMeta imeta = i.getItemMeta();
		List<String> lore = imeta.getLore();
		for(int j = 0; j<lore.size(); j++) {
			if(lore.get(j).contains("Blocks Broken: ")) {
				int amount = Integer.parseInt(ChatColor.stripColor(lore.get(j).replace("Blocks Broken: ", ""))) + 1;
				lore.set(j, this.files.changeColor("&8&lBlocks Broken: "+amount));
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				return;
			}
		}
	}
	public void incrementOresMined(ItemStack i) {
		ItemMeta imeta = i.getItemMeta();
		List<String> lore = imeta.getLore();
		for(int j = 0; j<lore.size(); j++) {
			if(lore.get(j).contains("Ores Mined: ")) {
				int amount = Integer.parseInt(ChatColor.stripColor(lore.get(j).replace("Ores Mined: ", ""))) + 1;
				lore.set(j, this.files.changeColor("&8&lOres Mined: "+amount));
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				return;
			}
		}
	}
	public void incrementLogsBroken(ItemStack i) {
		ItemMeta imeta = i.getItemMeta();
		List<String> lore = imeta.getLore();
		for(int j = 0; j<lore.size(); j++) {
			if(lore.get(j).contains("Logs Broken: ")) {
				int amount = Integer.parseInt(ChatColor.stripColor(lore.get(j).replace("Logs Broken: ", ""))) + 1;
				lore.set(j, this.files.changeColor("&8&lLogs Broken: "+amount));
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				return;
			}
		}
	}
	public void incrementDamageDealt(ItemStack i, int damage)
	{
		ItemMeta imeta = i.getItemMeta();
		List<String> lore = imeta.getLore();
		for(int j = 0; j<lore.size(); j++) {
			if(lore.get(j).contains("Damage Dealt: ")) {
				int amount = Integer.parseInt(ChatColor.stripColor(lore.get(j).replace("Damage Dealt: ", ""))) + damage;
				lore.set(j, this.files.changeColor("&8&lDamage Dealt: "+amount));
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				return;
			}
		}
	}
	public void incrementMobsKilled(ItemStack i) {
		ItemMeta imeta = i.getItemMeta();
		List<String> lore = imeta.getLore();
		for(int j = 0; j<lore.size(); j++) {
			if(lore.get(j).contains("Mobs Killed: ")) {
				int amount = Integer.parseInt(ChatColor.stripColor(lore.get(j).replace("Mobs Killed: ", ""))) + 1;
				lore.set(j, this.files.changeColor("&8&lMobs Killed: "+amount));
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				return;
			}
		}
	}
	public void incrementArrowsShot(ItemStack i) {
		ItemMeta imeta = i.getItemMeta();
		List<String> lore = imeta.getLore();
		for(int j = 0; j<lore.size(); j++) {
			if(lore.get(j).contains("Arrows Shot: ")) {
				int amount = Integer.parseInt(ChatColor.stripColor(lore.get(j).replace("Arrows Shot: ", ""))) + 1;
				lore.set(j, this.files.changeColor("&8&lArrows Shot: "+amount));
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				return;
			}
		}
	}
	
	
	public boolean hasBlockMined(ItemStack i) {
		if(i.hasItemMeta()) {
			ItemMeta imeta = i.getItemMeta();
			if(imeta.hasLore()) {
				List<String> lore = imeta.getLore();
				for(String lores: lore) {
					if(lores.startsWith(this.files.changeColor("&8&lBlocks Broken: "))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean hasOresMined(ItemStack i) {
		if(i.hasItemMeta()) {
			ItemMeta imeta = i.getItemMeta();
			if(imeta.hasLore()) {
				List<String> lore = imeta.getLore();
				for(String lores: lore) {
					if(lores.startsWith(this.files.changeColor("&8&lOres Mined: "))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean hasLogsBroken(ItemStack i) {
		if(i.hasItemMeta()) {
			ItemMeta imeta = i.getItemMeta();
			if(imeta.hasLore()) {
				List<String> lore = imeta.getLore();
				for(String lores: lore) {
					if(lores.startsWith(this.files.changeColor("&8&lLogs Broken: "))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean hasDamageDealt(ItemStack i) {
		if(i.hasItemMeta()) {
			ItemMeta imeta = i.getItemMeta();
			if(imeta.hasLore()) {
				List<String> lore = imeta.getLore();
				for(String lores: lore) {
					if(lores.startsWith(this.files.changeColor("&8&lDamage Dealt: "))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean hasMobsKilled(ItemStack i) {
		if(i.hasItemMeta()) {
			ItemMeta imeta = i.getItemMeta();
			if(imeta.hasLore()) {
				List<String> lore = imeta.getLore();
				for(String lores: lore) {
					if(lores.startsWith(this.files.changeColor("&8&lMobs Killed: "))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean hasArrowsShot(ItemStack i) {
		if(i.hasItemMeta()) {
			ItemMeta imeta = i.getItemMeta();
			if(imeta.hasLore()) {
				List<String> lore = imeta.getLore();
				for(String lores: lore) {
					if(lores.startsWith(this.files.changeColor("&8&lArrows Shot: "))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public Inventory getScrollInv(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(null, 9, this.files.getScrollInvName());
		inv.setItem(0, this.getGlassPane());
		inv.setItem(1, this.getBlockBrokenScroll(p));
		inv.setItem(2, this.getOresMinedScroll(p));
		inv.setItem(3, this.getDamageDealtScroll(p));
		inv.setItem(4, this.getGlassPane());
		inv.setItem(5, this.getMobsKilledScroll(p));
		inv.setItem(6, this.getArrowsShowScroll(p));
		inv.setItem(7, this.getLogsBrokenScroll(p));
		inv.setItem(8, this.getGlassPane());
		return inv;
	}
	public Inventory getScrollInfoInv() {
		Inventory inv = Bukkit.getServer().createInventory(null, 9, this.files.getScrollInvName());
		inv.setItem(0, this.getGlassPane());
		inv.setItem(1, this.getBlockBrokenScrollInfo());
		inv.setItem(2, this.getOresMinedScrollInfo());
		inv.setItem(3, this.getDamageDealtScrollInfo());
		inv.setItem(4, this.getGlassPane());
		inv.setItem(5, this.getMobsKilledScrollInfo());
		inv.setItem(6, this.getArrowsShowScrollInfo());
		inv.setItem(7, this.getLogsBrokenScrollInfo());
		inv.setItem(8, this.getGlassPane());
		return inv;
	}
	
	public ItemStack getGlassPane() {
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 3);
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(" ");
		i.setItemMeta(imeta);
		return i;
		
	}
	public ItemStack getBlockBrokenScroll(Player p) {
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getBlockBrokenScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dPickaxe, Shovel, Axe"));
		lore.add(changeColor(this.perms.permLore(p, this.perms.blocksBrokenPerm)));
		
		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getBlockBrokenScrollInfo() {
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getBlockBrokenScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dPickaxe, Shovel, Axe"));
		lore.add(" ");
		lore.add(changeColor("&6Scroll that count the amount of blocks broken using the designated item"));
		
		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getOresMinedScroll(Player p) {
		
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getOresMinedScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dPickaxe"));
		lore.add(changeColor(this.perms.permLore(p, this.perms.oresMinedPerm)));

		imeta.setLore(lore);		
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getOresMinedScrollInfo() {
		
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getOresMinedScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dPickaxe"));
		lore.add(" ");
		
		lore.add(changeColor("&6Scroll that count the amount of ores mined using the designated item"));
		lore.add(changeColor("&6Ores: Coal, Iron, Gold, Diamond, Redstone, Quartz, Emerald"));
		imeta.setLore(lore);		
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getDamageDealtScroll(Player p) {
		
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getDamageDealtScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dBow, Sword, Axe"));
		lore.add(changeColor(this.perms.permLore(p, this.perms.damageDealtPerm)));

		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getDamageDealtScrollInfo() {
		
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getDamageDealtScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dBow, Sword, Axe"));
		lore.add(" ");
		lore.add(changeColor("&6Scroll that count the amount of damage dealt to any mob using the designated item"));
		
		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getMobsKilledScroll(Player p) {	
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getMobsKilledScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dBow, Sword"));
		lore.add(changeColor(this.perms.permLore(p, this.perms.mobsKilledPerm)));

		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}	
	public ItemStack getMobsKilledScrollInfo() {	
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getMobsKilledScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dBow, Sword"));
		lore.add(" ");
		lore.add(changeColor("&6Scroll that count the amount of mobs killed using the designated item"));

		
		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}	
	public ItemStack getArrowsShowScroll(Player p) {
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getArrowsShotScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dBow"));
		lore.add(changeColor(this.perms.permLore(p, this.perms.arrowsShotPerm)));

		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getArrowsShowScrollInfo() {
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getArrowsShotScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dBow"));
		lore.add(" ");
		lore.add(changeColor("&6Scroll that count the amount of arrows shot using the designated item"));

		
		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getLogsBrokenScroll(Player p) {
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getLogsBrokenScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dAxe"));
		lore.add(changeColor(this.perms.permLore(p, this.perms.logsBrokenPerm)));

		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	public ItemStack getLogsBrokenScrollInfo() {
		ItemStack i = new ItemStack(this.getScrollMaterial(), 1, (byte) this.getScrollDataValue());
		ItemMeta imeta = i.getItemMeta();
		imeta.setDisplayName(changeColor(this.files.getLogsBrokenScroll()));
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(changeColor("&5&lAppicable on: &dAxe"));
		lore.add(" ");
		lore.add(changeColor("&6Scroll that count the amount of tree logs broken using the designated item"));
		lore.add(changeColor("&6Logs: Oak Log, Spruce Log, Acacia Log, Jungle Log, Dark Oak Log, Birch Log"));
		
		
		imeta.setLore(lore);
		
		i.setItemMeta(imeta);
		return i;
	}
	
	public boolean isOre(Block b) {
		return getOreList().contains(b.getType());
	}
	public boolean isLog(Block b) {
		return getLogList().contains(b.getType());
	}
	public boolean isPickaxe(ItemStack i) {
		return getPickaxeList().contains(i.getType());
	}
	public boolean isShovel(ItemStack i) {
		return getShovelList().contains(i.getType());
	}
	public boolean isAxe(ItemStack i) {
		return getAxeList().contains(i.getType());
	}
	public boolean isSword(ItemStack i) {
		return getSwordList().contains(i.getType());
	}
	public boolean isBow(ItemStack i) {
		return i.getType() == Material.BOW;
	}
	
	private ArrayList<Material> getOreList() {
		ArrayList<Material> list = new ArrayList<Material>();
		list.add(Material.DIAMOND_ORE);
		list.add(Material.GOLD_ORE);
		list.add(Material.IRON_ORE);
		list.add(Material.EMERALD_ORE);
		list.add(Material.QUARTZ_ORE);
		list.add(Material.REDSTONE_ORE);
		list.add(Material.COAL_ORE);
		list.add(Material.LAPIS_ORE);
		
		return list;
	}
	private ArrayList<Material> getPickaxeList() {
		ArrayList<Material> list = new ArrayList<Material>();
		list.add(Material.DIAMOND_PICKAXE);
		list.add(Material.IRON_PICKAXE);
		list.add(Material.GOLD_PICKAXE);
		list.add(Material.STONE_PICKAXE);
		list.add(Material.WOOD_PICKAXE);
		
		return list;
	}
	private ArrayList<Material> getShovelList() {
		ArrayList<Material> list = new ArrayList<Material>();
		list.add(Material.DIAMOND_SPADE);
		list.add(Material.GOLD_SPADE);
		list.add(Material.IRON_SPADE);
		list.add(Material.STONE_SPADE);
		list.add(Material.WOOD_SPADE);
		
		return list;
	}
	private ArrayList<Material> getAxeList() {
		ArrayList<Material> list = new ArrayList<Material>();
		list.add(Material.DIAMOND_AXE);
		list.add(Material.GOLD_AXE);
		list.add(Material.IRON_AXE);
		list.add(Material.STONE_AXE);
		list.add(Material.WOOD_AXE);
		
		return list;
	}
	private ArrayList<Material> getSwordList() {
		ArrayList<Material> list = new ArrayList<Material>();
		list.add(Material.DIAMOND_SWORD);
		list.add(Material.GOLD_SWORD);
		list.add(Material.IRON_SWORD);
		list.add(Material.STONE_SWORD);
		list.add(Material.WOOD_SWORD);
		
		return list;
	}
	private ArrayList<Material> getLogList() {
		ArrayList<Material> list = new ArrayList<Material>();
		list.add(Material.LOG);
		list.add(Material.LOG_2);
		
		return list;
	}
	
	private String changeColor(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
