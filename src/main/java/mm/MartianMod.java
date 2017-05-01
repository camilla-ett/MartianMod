package mm;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = MartianMod.MODID, version = MartianMod.VERSION)
public class MartianMod {
	public static final String MODID = "MartianMod";
	public static final String MODNAME = "Martian Mod";
	public static final String VERSION = "beta 0.0.1";
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event){
		// called before minecraft initialiuzation
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// called after initialization
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent e)
	{
		// only server initialization
	}
	
	public String getVersion() {
		return VERSION;
	}
}
