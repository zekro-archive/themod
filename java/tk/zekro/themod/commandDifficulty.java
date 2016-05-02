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
import java.util.List;


public class commandDifficulty extends CommandBase {

	@Override
	public String getCommandName() {
		return themod.customCommandDiff;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/" + themod.customCommandDiff;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		EntityPlayer player = (EntityPlayer) sender;
		themod.difficulty = player.getEntityWorld().difficultySetting.getDifficultyId();
		Minecraft.getMinecraft().thePlayer.sendChatMessage("/difficulty 0");
	}
}
