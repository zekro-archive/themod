package tk.zekro.themod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

public class eventListener {

	public static boolean playerIsInBed = false;
	public static String playerName;
	
	@SubscribeEvent
	public void onPlayerSleep(PlayerSleepInBedEvent event) {
		
		if (!event.entityPlayer.worldObj.provider.isDaytime() && !event.entityPlayer.worldObj.isRemote) {
			playerIsInBed = true;
			playerName = event.entityPlayer.getDisplayName();
		}
		
	}
	
	@SubscribeEvent
	public void onPlayerNotSleep(PlayerWakeUpEvent event) {
		if (event.entityPlayer.worldObj.provider.isDaytime() && !event.entityPlayer.worldObj.isRemote) {
			playerIsInBed = false;
		}
	}
}
