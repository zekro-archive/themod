package tk.zekro.themod;

import javax.security.auth.login.Configuration;

import com.typesafe.config.Config;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tk.zekro.themod.proxies.themodProxy;


@Mod(modid="themod", name="THE Mod", version="1.3.2-0041")
public class themod {

	@SidedProxy(clientSide="tk.zekro.themod.proxies.themodClientProxy", serverSide="tk.zekro.themod.proxies.themodProxy")
	public static themodProxy proxy;
	
	@Instance(value="themod")
	public static themod instance;
	
	public static String successfulChatMessage;
	public static String notSuccessfulChatMessage;
	public static String customCommand;
	public static boolean playSound;
	public static float volumeSound;
	public static boolean showMessage;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
		
		//--> CONFIG
		net.minecraftforge.common.config.Configuration config = new net.minecraftforge.common.config.Configuration(event.getSuggestedConfigurationFile());
		System.out.println("[THEMod] Configuration loadet.");
		System.out.println("[THEMod] Config found at:" + event.getSuggestedConfigurationFile());
		config.load();
		
		customCommand = config.getString("COMMAND", "special", "day", "Command without '/'.");
		playSound = config.getBoolean("PLAYSOUND", "sound", true, "Enable/Disable sound by command input. ('true'/'false')");
		volumeSound = config.getFloat("SOUNDVOLUME", "sound", 1.0F, 0.0F, 3.0F, "Sound volume (Float 0 - 3)");
		showMessage = config.getBoolean("SHOWMESSAGE", "special", true, "Enable/Disable message by command input. ('true'/'false')");
		successfulChatMessage = config.getString("MESSAGE WHEN SUCCESSFUL", "ingame_messages", "THEM Mod has beed executed!", "Type in the text wich is sown if the command was executed successful");
		notSuccessfulChatMessage = config.getString("MESSAGE WHEN NOT SUCCESSFUL", "ingame_messages", "You have to be in a bed to use this command!", "Type in the text wich is sown if the command was executed with not allowed events (time is day, player not in bed)");
		
		config.save();
		//<-- CONFIG
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		//Get the event if the player is in bed or not from the 'eventListener.class'
		MinecraftForge.EVENT_BUS.register(new eventListener());
	}
	
	public void postInit(FMLPostInitializationEvent event) {}
	
	
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		//registering of the new command /day (or what is defined in the config.cfg ^^)
		ServerCommandManager manager = (ServerCommandManager) event.getServer().getCommandManager();
		manager.registerCommand(new commandTime());
	}
}
