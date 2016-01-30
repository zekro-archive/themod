package tk.zekro.themod;

import com.sun.media.jfxmedia.events.PlayerEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;


public class eventListener {

	public static boolean playerIsInBed = false;
	public static String playerName;
	
	@SubscribeEvent
	/*   1. check event if the player joined a world
	 *   2. if the updateService.class detected a update AND the update message is enabled in the coinfig
	 *    -> ingame update message
	 */
	public void onPlayerLogin(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
		if (updateService.newVersionAvailable && themod.showUpdateInfo) {
			event.player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.AQUA + "[THEMod] " + EnumChatFormatting.WHITE + "A new version of this mod is available!"));
			event.player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GRAY + " You can donwload it here: "));
			event.player.addChatMessage(new ChatComponentText(
					EnumChatFormatting.ITALIC.GRAY + "https://github.com/zekroTJA/THE-Mod./releases"));
		}
	}
	
	//Check if the player is in a bed and if it is night
	@SubscribeEvent
	public void onPlayerSleep(PlayerSleepInBedEvent event) {
		if (!event.entityPlayer.worldObj.provider.isDaytime() && !event.entityPlayer.worldObj.isRemote)  {
			playerIsInBed = true;
			playerName = event.entityPlayer.getDisplayName();
		}
	}
	
	//similar but here its checked if its day after sleeping and the player was awaked
	@SubscribeEvent
	public void onPlayerNotSleep(PlayerWakeUpEvent event) {
		if (/*event.entityPlayer.worldObj.provider.isDaytime() &&*/ !event.entityPlayer.worldObj.isRemote) {
			playerIsInBed = false;
		}
	}	
}
