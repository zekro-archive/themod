package tk.zekro.themod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class soundPlayer {

	public static final void playSound(EntityPlayer player, String name, float pitch, float volume) {
		player.playSound("themod:" + name, volume, pitch);
	}
	
	public static final void playSoundMenue(String name, float pitch, float volume) {
		Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147673_a(new ResourceLocation("themod:" + name)));
	}
}
