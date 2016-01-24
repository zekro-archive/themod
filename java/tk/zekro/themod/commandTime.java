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

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		
		if (sender instanceof EntityPlayer && eventListener.playerIsInBed) {
			
			EntityPlayer player = (EntityPlayer) sender;
			System.out.println(EnumChatFormatting.RED + "THEMOD HAS BIN EXECUTED!");
			if (themod.showMessage) {
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "[THEMod] " + EnumChatFormatting.WHITE + "DER MOD wurde ausgeführt!"));
			}
			if (themod.playSound) {
				Random randGen = new Random();
				int rand = randGen.nextInt(4);
				soundPlayer.playSoundMenue("dominik" + rand, 1, themod.volumeSound);
			}
			setTime(player.getEntityWorld());
		} else {
			if (!eventListener.playerIsInBed) {
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "[THEMod] " + EnumChatFormatting.WHITE + "Du musst im Bett liegen um diesen Command ausführen zu können!"));
			} else {
				sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[THEMod] Dieser Command ist nicht ind er Consolse ausführbar!"));
			}
		}
	}
	
	public void setTime(World world){
		world.setWorldTime(0);
	}
}
