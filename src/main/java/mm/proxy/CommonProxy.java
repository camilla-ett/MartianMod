package mm.proxy;

import mm.world.WorldTypeMartianMars;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	WorldType martianMars;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		martianMars = new WorldTypeMartianMars();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}

}
