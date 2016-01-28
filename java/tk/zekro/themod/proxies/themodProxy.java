package tk.zekro.themod.proxies;

import net.minecraftforge.common.MinecraftForge;
import tk.zekro.themod.eventListener;

public class themodProxy {
	
	public void registerRenderers(){}

	public void initSounds() {
		MinecraftForge.EVENT_BUS.register(new eventListener());
	}
	

}
