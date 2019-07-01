package me.mariozgr8.superscrolls.Listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

//import me.mariozgr8.superscrolls.FileManager;
import me.mariozgr8.superscrolls.SuperScrolls;
import me.mariozgr8.superscrolls.Handlers.ScrollHandler;

public class ScrollListener implements Listener {
	private SuperScrolls ss = SuperScrolls.getMain();
	private ScrollHandler handler = ss.getManager();
//	private FileManager files = ss.getFiles();
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack i = p.getInventory().getItemInMainHand();
		if(this.handler.hasBlockMined(i)) {
			this.handler.incrementBlockBroken(i);
		}
		if(this.handler.hasOresMined(i)) {
			Block b = e.getBlock();
			if(this.handler.isOre(b)) {
				this.handler.incrementOresMined(i);
			}
		}
		if(this.handler.hasLogsBroken(i)) {
			Block b = e.getBlock();
			if(this.handler.isLog(b)) { 
				this.handler.incrementLogsBroken(i);
			}
		}
	}
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			Player p = (Player) e.getEntity().getKiller();
			ItemStack i = p.getInventory().getItemInMainHand();
			if(this.handler.hasMobsKilled(i)) {
				Entity et = e.getEntity();
				if(et instanceof LivingEntity) {
					this.handler.incrementMobsKilled(i);
				}
			}
			if(this.handler.hasPlayersKilled(i)) {
				p.sendMessage("Worked");
				Entity et = e.getEntity();
				if(et instanceof Player) {
					this.handler.incrementPlayersKilled(i);
				}
			}
		}	
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			ItemStack i = p.getInventory().getItemInMainHand();
			if(this.handler.hasDamageDealt(i)) {
				Entity et = e.getEntity();
				if(et instanceof LivingEntity) {
					this.handler.incrementDamageDealt(i, (int) e.getDamage());
				}
			}
		}
	}
	@EventHandler
	public void onBowShoot(EntityShootBowEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			ItemStack i = p.getInventory().getItemInMainHand();
			if(this.handler.hasArrowsShot(i)) {
				this.handler.incrementArrowsShot(i);
			}
		}
	}
}
