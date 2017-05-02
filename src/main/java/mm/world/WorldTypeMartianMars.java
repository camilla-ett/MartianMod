package mm.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderOverworld;

public class WorldTypeMartianMars extends WorldType {
	
	private static BiomeProviderMM biomeProvider;
	private static ChunkProviderMM chunkProvider;

	public WorldTypeMartianMars()
	{
		super("martian_mars");
	}
/*	
	@Override
	public BiomeProvider getBiomeProvider(World world)
	{
		// Only Overworld
		if (world.provider.getDimension() == 0) {
			if (biomeProvider == null) {
				biomeProvider = new BiomeProviderMM(world);
			}
			return biomeProvider;
		}
		else {
			return new BiomeProvider(world.getWorldInfo());
		}
	}
*/
	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions)
	{
		// Only Overworld
		if (world.provider.getDimension() == 0) {
			if (chunkProvider == null) {
				chunkProvider = new ChunkProviderMM(world);
			}
			return chunkProvider;
		}
		else {
			 return new ChunkProviderOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
		}
	}
	
	@Override
	public float getCloudHeight()
	{
		return -100f;
	}
}
