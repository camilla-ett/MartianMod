package mm.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;

public class WorldTypeMartianMars extends WorldType {

	public WorldTypeMartianMars() {
		super("martian_mars");
	}
	
	@Override
	public IChunkGenerator getChunkGenerator(World world, String option)
	{
		return new MartinMarsChunkProvider(world);
	}
}
