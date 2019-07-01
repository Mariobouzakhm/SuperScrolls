package me.mariozgr8.superscrolls.Listeners;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mariozgr8.superscrolls.FileManager;
import me.mariozgr8.superscrolls.PermissionManager;
import me.mariozgr8.superscrolls.SuperScrolls;
import me.mariozgr8.superscrolls.Handlers.ScrollHandler;

public class ClickListener implements Listener {
	private FileManager files = SuperScrolls.getMain().getFiles();
	private ScrollHandler handler = SuperScrolls.getMain().getManager();
	private PermissionManager perms = SuperScrolls.getMain().getPerms();
	
	@EventHandler
	public void onClickEvent(InventoryClickEvent e) {
		if(e.getInventory() == null) {
			return;
		}
		if(e.getCurrentItem() == null) {
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack i = e.getCurrentItem();
		
		//Cancel all the events related to the plugin
		if(inv.getName().equalsIgnoreCase(this.files.getScrollInvName()) || inv.getName().equals(this.files.getScrollInfoInvName())) {
			e.setCancelled(true);
		}
		
		//Actions relating to the main scroll inv
		if(inv.getName().equalsIgnoreCase(this.files.getScrollInvName())) {
			if(i.equals(this.handler.getGlassPane())) {
				e.setCancelled(true);
			}
			ItemStack it = p.getInventory().getItemInMainHand();
			if(i.equals(this.handler.getBlockBrokenScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.blocksBrokenPerm)) 
				{
					if(this.handler.isPickaxe(it) || this.handler.isShovel(it) || this.handler.isAxe(it)) {
						if(this.handler.hasBlockMined(it)) {
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(it.getItemMeta().getLore());
							}
							newLore.add(this.files.changeColor("&8&lBlocks Broken: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for pickaxe, shovel and axe !");
						return;
					}
				}
			}
			if(i.equals(this.handler.getOresMinedScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.oresMinedPerm)) 
				{
					if(this.handler.isPickaxe(it)) {
						if(this.handler.hasOresMined(it)) {
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(it.getItemMeta().getLore());
							}
							newLore.add(this.files.changeColor("&8&lOres Mined: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for pickaxe !");
						return;
					}
				}
			}
			if(i.equals(this.handler.getLogsBrokenScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.logsBrokenPerm))
				{
					if(this.handler.isAxe(it)) {
						if(this.handler.hasLogsBroken(it)) {
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(it.getItemMeta().getLore());
							}
							newLore.add(this.files.changeColor("&8&lLogs Broken: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for axe !");
						return;
					}
				}
			}
			if(i.equals(this.handler.getDamageDealtScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.damageDealtPerm))
				{
					if(this.handler.isSword(it) || this.handler.isBow(it) || this.handler.isAxe(it)) {
						if(this.handler.hasDamageDealt(it)) {
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(it.getItemMeta().getLore());
							}
							newLore.add(this.files.changeColor("&8&lDamage Dealt: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for axe, sword and bow !");
						return;
					}
				}
			}
			if(i.equals(this.handler.getMobsKilledScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.mobsKilledPerm))
				{
					if(this.handler.isSword(it) || this.handler.isBow(it)) {
						if(this.handler.hasMobsKilled(it)) {
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(it.getItemMeta().getLore());
							}
							newLore.add(this.files.changeColor("&8&lMobs Killed: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for sword and bow !");
						return;
					}
				}
			}
			if(i.equals(this.handler.getArrowsShowScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.arrowsShotPerm))
				{
					if(this.handler.isBow(it)) {
						if(this.handler.hasArrowsShot(it)) {
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(it.getItemMeta().getLore());
							}
							newLore.add(this.files.changeColor("&8&lArrows Shot: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for bow !");
						return;
					}
				}
			}
			if(i.equals(this.handler.getPlayersKilledScroll(p))) {
				if(this.perms.hasPermission(p, this.perms.playersKilledPerm)) {
					if(this.handler.isSword(it) || this.handler.isBow(it)) {
						if(this.handler.hasPlayersKilled(it)) {
							p.sendMessage("2");
							this.files.sendMessageToPlayer(p, "&6This scroll is already applied to this item !");
							return;
						}
						else {
							p.sendMessage("1");
							ItemMeta imeta = it.getItemMeta();
							ArrayList<String> newLore = new ArrayList<String>();
							if(imeta.hasLore()) {
								newLore.addAll(imeta.getLore());
							}
							newLore.add(this.files.changeColor("&8&lPlayers Killed: 0"));
							imeta.setLore(newLore);
							it.setItemMeta(imeta);
						}
					}
					else {
						this.files.sendMessageToPlayer(p, "&6This scroll is only applicable for swords and bows !");
						return;
					}
				}
			}
		}
	}
}