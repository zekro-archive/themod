package tk.zekro.themod.proxies;

import cpw.mods.fml.common.Mod.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import tk.zekro.themod.eventListener;

public class themodClientProxy extends themodProxy {

	@Override
	public void registerRenderers() {}
	
	@Override
	public void initSounds() {
		MinecraftForge.EVENT_BUS.register(new eventListener());
	}
}
