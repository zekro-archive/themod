package tk.zekro.themod;

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
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tk.zekro.themod.proxies.themodProxy;


@Mod(modid="themod", name="THE Mod", version="1.0.0-0011")
public class themod {

	@SidedProxy(clientSide="tk.zekro.themod.proxies.themodClientProxy", serverSide="tk.zekro.themod.proxies.themodProxy")
	public static themodProxy proxy;
	
	@Instance(value="themod")
	public static themod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {}
	
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
