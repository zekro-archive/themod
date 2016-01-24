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


@Mod(modid="themod", name="THE Mod", version="1.2.0-0016")
public class themod {

	@SidedProxy(clientSide="tk.zekro.themod.proxies.themodClientProxy", serverSide="tk.zekro.themod.proxies.themodProxy")
	public static themodProxy proxy;
	
	@Instance(value="themod")
	public static themod instance;
	
	public static String customCommand;
	public static boolean playSound;
	public static float volumeSound;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		//--> CONFIG
		net.minecraftforge.common.config.Configuration config = new net.minecraftforge.common.config.Configuration(event.getSuggestedConfigurationFile());
		System.out.println("[THEMod] Configuration loadet.");
		System.out.println("[THEMod] Config found at:" + event.getSuggestedConfigurationFile());
		config.load();
		
		customCommand = config.getString("COMMAND", "customCommand", "day", "Command without '/'.");
		playSound = config.getBoolean("PLAYSOUND", "sound", true, "Enable/Disable sound by command input. ('true'/'false')");
		volumeSound = config.getFloat("SOUNDVOLUME", "sound", 1, 0, 3, "Sound volume (Float 0 - 3)");
		
		config.save();
		//<-- CONFIG
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
	
	public void postInit(FMLPostInitializationEvent event) {}
	
	
	@EventHandler
	public void registerCommands(FMLServerStartingEvent event) {
		ServerCommandManager manager = (ServerCommandManager) event.getServer().getCommandManager();
		manager.registerCommand(new commandTime());
	}
}
