package tk.zekro.themod;

import net.minecraft.client.Minecraft;
import java.util.Random;
import net.minecraft.client.multiplayer.WorldClient;
import java.util.Random;
import akka.actor.FSM.Event;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModClassLoader;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;

public class commandTime extends CommandBase {
	
	@Override
	public String getCommandName() {
		return themod.customCommand;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/" + themod.customCommand;
	}

	//generates a new command "/day" (or like it is configured in the config file)
	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		
		if (sender instanceof EntityPlayer && eventListener.playerIsInBed) {
			
			EntityPlayer player = (EntityPlayer) sender;
			System.out.println(EnumChatFormatting.RED + "THEMOD HAS BIN EXECUTED!");
			if (themod.showMessage) {
				
				//Chat Message after successful command input
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[THEMod] " + EnumChatFormatting.WHITE + themod.successfulChatMessage));
			}
			if (themod.playSound) {
				Random randGen = new Random();
				int rand = randGen.nextInt(4);
				
				player.getEntityWorld().playSoundAtEntity(player, "themod:dominik" + rand , 1.0F, themod.volumeSound);
				
//OLD SOUND PLAYER	 soundPlayer.playSoundMenue("dominik" + rand, 1, themod.volumeSound);
			}
			
			//set the world time to day after entering the command
			setTime(player.getEntityWorld());
		} else {
			if (!eventListener.playerIsInBed) {
				//Chat Message after type in the command with not allowed world events (time is day, player not in bed)
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[THEMod] " + EnumChatFormatting.WHITE + themod.notSuccessfulChatMessage));
			} else {
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[THEMod] This command is not a consol command!"));
			}
		}
	}
	
	public void setTime(World world){
		world.setWorldTime(0);
	}
}
