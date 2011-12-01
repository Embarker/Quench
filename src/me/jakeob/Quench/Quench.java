package me.jakeob.Quench;

import java.util.logging.Logger;

import me.jakeob.Quench.QuenchPlayerListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Quench
 * @version 1.1
 * @author Jakeob22
 **/

public class Quench extends JavaPlugin {
    private final QuenchPlayerListener playerListener = new QuenchPlayerListener(this);
	Logger log = Logger.getLogger("Minecraft");
	//Declaring variables
	public boolean bEmptyBucket;
	public boolean bHungerWater;
	public boolean bHungerMilk;
	public boolean bHungerLava;
	public boolean bHealthWater;
	public boolean bHealthMilk;
	public boolean bHealthLava;
	public boolean bPlayerSender;
	public int iWaterHungerValue;
	public int iMilkHungerValue;
	public int iLavaHungerValue;
	public int iWaterHealthValue;
	public int iMilkHealthValue;
	public int iLavaHealthValue;
	 
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
		loadConfiguration(); //calls the loadConfiguration function
		log.info("Quench has been enabled!");
	}
 
	public void onDisable(){
		log.info("Quench has been disabled.");
	}
	public void loadConfiguration(){ 
		 //Loading the config into the variables
		 this.bEmptyBucket = getConfig().getBoolean("Config.Empty the bucket?");
		 this.bHungerWater = getConfig().getBoolean("Config.Helps Hunger?.Water");
		 this.bHungerMilk = getConfig().getBoolean("Config.Helps Hunger?.Milk");
		 this.bHungerLava = getConfig().getBoolean("Config.Helps Hunger?.Lava");
		 this.bHealthWater = getConfig().getBoolean("Config.Helps Health?.Water");
		 this.bHealthMilk = getConfig().getBoolean("Config.Helps Health?.Milk");
		 this.bHealthLava = getConfig().getBoolean("Config.Helps Health?.Lava");
		 this.iWaterHungerValue = getConfig().getInt("Config.How much hunger?.Water");
		 this.iMilkHungerValue = getConfig().getInt("Config.How much hunger?.Milk");
		 this.iLavaHungerValue = getConfig().getInt("Config.How much hunger?.Lava");
		 this.iWaterHealthValue = getConfig().getInt("Config.How much health?.Water");
		 this.iMilkHealthValue = getConfig().getInt("Config.How much health?.Milk");
		 this.iLavaHealthValue = getConfig().getInt("Config.How much health?.Lava");
	     getConfig().options().copyDefaults(true);
	     saveConfig();
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
			bPlayerSender = true;
		}
		//The Boolean PlayerSender will tell the plugin if a player is doing the command or if it's from the command window.
		//If it's by a player, it will also check if they have permission to do it. The default is op only.
		if(cmd.getName().equalsIgnoreCase("reloadquench") && bPlayerSender == true && player.hasPermission("quench.reload")){
			reloadConfig();
			loadConfiguration(); //These do the loadConfiguration config again, to get new data for the variables from the config.
			bPlayerSender = false;
			log.info("Quench's config has been reloaded.");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("reloadquench") && bPlayerSender == false){
			reloadConfig();
			loadConfiguration();
			log.info("Quench's config has been reloaded.");
			return true;
		}
		return false;  
	}
}