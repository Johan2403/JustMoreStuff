package johan24.justmorestuff.util;

import johan24.justmorestuff.JustMoreStuff;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
@Config(modid = JustMoreStuff.MODID, name = "justmorestuff_config", type = Type.INSTANCE)
public class JustMoreStuffConfig {
	
	@Name("Gui ID's")
	@Comment("Contains variables for GUI IDs for the Mod JustMoreStuff.")
	public static GuiIDs guiIDs = new GuiIDs();
	
	public static class GuiIDs {
		@Name("Smithing Table GUI ID")
		@Comment("Sets the GUI ID for the Smithing Table GUI.")
		public int GUI_SMITHING_TABLE = 0;
	}
	
	@SubscribeEvent
	public static void onConfigChange(OnConfigChangedEvent event) {
		if(event.getModID().equals(JustMoreStuff.MODID))
			ConfigManager.sync(JustMoreStuff.MODID, Type.INSTANCE);
	}
}