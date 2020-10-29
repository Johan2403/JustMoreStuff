package johan24.justmorestuff.util;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

	public static SoundEvent SMITHING_TABLE_USE;
	
	public static void registerSounds() {
		SMITHING_TABLE_USE = registerSound("block.smithing_table.use");
	}
	
	private static SoundEvent registerSound(String name) {
		ResourceLocation location = new ResourceLocation(JustMoreStuff.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
