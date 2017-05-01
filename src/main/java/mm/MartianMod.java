package mm;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import mm.proxy.CommonProxy;

@Mod(modid = MartianMod.MODID, version = MartianMod.VERSION)
public class MartianMod {
	public static final String MODID = "MartianMod";
	public static final String MODNAME = "Martian Mod";
	public static final String VERSION = "beta 0.0.1";
	
	@SidedProxy(clientSide = "mm.proxy.ClientProxy", serverSide = "mm.proxy.ServerProxy", modId = MODID)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event){
		// called before minecraft initialization
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// called after initialization
		proxy.postInit(event);
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
