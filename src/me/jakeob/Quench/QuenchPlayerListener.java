package me.jakeob.Quench;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;


public class QuenchPlayerListener extends PlayerListener{
	public Quench plugin;
	public int iCurrentFood;
	public int iNewFood;
	public int iCurrentHealth;
	public int iNewHealth;
	 
	public QuenchPlayerListener(Quench instance) {
	    plugin = instance;
	}
	
	//water ID  = 326
	//milk ID   = 335
	//lava ID   = 327
	//bucket ID = 325
	
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getPlayer().getItemInHand().getTypeId() == 326 && event.getAction() == Action.RIGHT_CLICK_AIR){
			//If they are holding a water bucket and right click the air, it will run this.
			if (plugin.bHungerWater == true){ //If "Water", under "Helps Hunger?" is true, it will run this
			    this.iCurrentFood = event.getPlayer().getFoodLevel();
				this.iNewFood = this.iCurrentFood + plugin.iWaterHungerValue; 
				//The value that will become the new food level is the current level for food and the value they set for water to heal.
				if (this.iNewFood > 20){
					this.iNewFood = 20;
				}
				if (this.iNewFood < 0){
					this.iNewFood = 0;
				}
				//If the new level is above the max(20) or below the min(0), it will set it to the highest or lowest possible. (Just to be safe)
				event.getPlayer().setFoodLevel(this.iNewFood); //Changes your food level to your old food plus the value set for the drink.
			}
			
			//I used the same system for health
			if (plugin.bHealthWater == true){
			    this.iCurrentHealth = event.getPlayer().getHealth();
				this.iNewHealth = this.iCurrentHealth + plugin.iWaterHealthValue;
				if (this.iNewHealth > 20){
					this.iNewHealth = 20;
				}
				if (this.iNewHealth < 0){
					this.iNewHealth = 0;
				}
				event.getPlayer().setHealth(this.iNewHealth);
			}
			//If they set "Empty the bucket?" to true, it will change the drink they used into an empty bucket.
		    if (plugin.bEmptyBucket == true){
		    	if (plugin.bHungerWater == true || plugin.bHealthWater == true){
				    event.getPlayer().getItemInHand().setTypeId(325);
		    	}
		    }
		}
		
		//I used the same system for the other drinks! :D
		if (event.getPlayer().getItemInHand().getTypeId() == 335 && event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (plugin.bHungerMilk == true){
			    this.iCurrentFood = event.getPlayer().getFoodLevel();
				this.iNewFood = this.iCurrentFood + plugin.iMilkHungerValue;
				if (this.iNewFood > 20){
					this.iNewFood = 20;
				}
				if (this.iNewFood < 0){
					this.iNewFood = 0;
				}
				event.getPlayer().setFoodLevel(this.iNewFood);
			}
			if (plugin.bHealthMilk == true){
			    this.iCurrentHealth = event.getPlayer().getHealth();
				this.iNewHealth = this.iCurrentHealth + plugin.iMilkHealthValue;
				if (this.iNewHealth > 20){
					this.iNewHealth = 20;
				}
				if (this.iNewHealth < 0){
					this.iNewHealth = 0;
				}
				event.getPlayer().setHealth(this.iNewHealth);
			}
		    if (plugin.bEmptyBucket == true){
		    	if (plugin.bHungerMilk == true || plugin.bHealthMilk == true){
				    event.getPlayer().getItemInHand().setTypeId(325);
		    	}
		    }
	    }
		
		if (event.getPlayer().getItemInHand().getTypeId() == 327 && event.getAction() == Action.RIGHT_CLICK_AIR) {
			if (plugin.bHungerLava == true){
			    this.iCurrentFood = event.getPlayer().getFoodLevel();
				this.iNewFood = this.iCurrentFood + plugin.iLavaHungerValue;
				if (this.iNewFood > 20){
					this.iNewFood = 20;
				}
				if (this.iNewFood < 0){
					this.iNewFood = 0;
				}
				event.getPlayer().setFoodLevel(this.iNewFood);
			}
			if (plugin.bHealthLava == true){
			    this.iCurrentHealth = event.getPlayer().getHealth();
				this.iNewHealth = this.iCurrentHealth + plugin.iLavaHealthValue;
				if (this.iNewHealth > 20){
					this.iNewHealth = 20;
				}
				if (this.iNewHealth < 0){
					this.iNewHealth = 0;
				}
				event.getPlayer().setHealth(this.iNewHealth);
			}
		    if (plugin.bEmptyBucket == true){
		    	if (plugin.bHungerLava == true || plugin.bHealthLava == true){
				    event.getPlayer().getItemInHand().setTypeId(325);
		    	}
		    }
	    }
    }
}
//JAKEOB22 IS AWESOME FOR CODING THIS FOR THE COMMUNITY. :P