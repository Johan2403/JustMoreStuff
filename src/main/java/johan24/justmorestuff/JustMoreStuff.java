package johan24.justmorestuff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import johan24.justmorestuff.network.GuiHandler;
import johan24.justmorestuff.recipes.ModRecipes;
import johan24.justmorestuff.util.OreDictionaryCompat;
import johan24.justmorestuff.util.SoundsHandler;
import johan24.justmorestuff.world.gen.ModOresWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = JustMoreStuff.MODID, name = JustMoreStuff.NAME, version = JustMoreStuff.VERSION, acceptedMinecraftVersions = JustMoreStuff.MC_VERSION, updateJSON = "https://gist.githubusercontent.com/Johan2403/de7b4d0b447c5250cc3fcd5931dec56b/raw/JustMoreStuffUpdateJSON.json")
public class JustMoreStuff {
	
	public static final String MODID = "justmorestuff";
	public static final String NAME = "Just More Stuff";
	public static final String VERSION = "1.12.2-1.1";
	public static final String MC_VERSION = "[1.12.2]";

	public static final Logger LOGGER = LogManager.getLogger(JustMoreStuff.MODID);
	
	public static final CreativeTabs JUSTMORESTUFF_TAB = new JustMoreStuffTab();
	
	@Instance(JustMoreStuff.MODID)
	public static JustMoreStuff instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		LOGGER.info(JustMoreStuff.NAME + " says hi!");
		OreDictionaryCompat.registerOres();
		ModRecipes.initSmelting();
		SoundsHandler.registerSounds();
		GameRegistry.registerWorldGenerator(new ModOresWorldGen(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(JustMoreStuff.instance, new GuiHandler());
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
