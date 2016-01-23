package tk.zekro.themod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import akka.actor.FSM.Event;
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
		return "day";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/day";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		
		if (sender instanceof EntityPlayer) {
			
			EntityPlayer player = (EntityPlayer) sender;
			System.out.println(EnumChatFormatting.RED + "THEMOD HAS BIN EXECUTED!");
			soundPlayer.playSoundMenue("dominik", 1, 1);
			setTime(player.getEntityWorld());
		} else {
			sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Dieser Command ist nicht ind er Consolse ausführbar!"));
		}
	}
	
	public void setTime(World world){
		world.setWorldTime(0);
	}

}
