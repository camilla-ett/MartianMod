package mm.world;

import java.util.List;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;

public class BiomeProviderMM extends BiomeProvider {
	
	private World world;
	
	public BiomeProviderMM(World world)
	{
		this.world = world;
	}

	@Override
	public List<Biome> getBiomesToSpawnIn() {
		// TODO Auto-generated method stub
		return super.getBiomesToSpawnIn();
	}

	@Override
	public Biome getBiome(BlockPos pos) {
		// TODO Auto-generated method stub
		return super.getBiome(pos);
	}

	@Override
	public Biome getBiome(BlockPos pos, Biome defaultBiome) {
		// TODO Auto-generated method stub
		return super.getBiome(pos, defaultBiome);
	}

	@Override
	public float getTemperatureAtHeight(float p_76939_1_, int p_76939_2_) {
		// TODO Auto-generated method stub
		return super.getTemperatureAtHeight(p_76939_1_, p_76939_2_);
	}

	@Override
	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height) {
		// TODO Auto-generated method stub
		return super.getBiomesForGeneration(biomes, x, z, width, height);
	}

	@Override
	public Biome[] getBiomes(Biome[] oldBiomeList, int x, int z, int width, int depth) {
		// TODO Auto-generated method stub
		return super.getBiomes(oldBiomeList, x, z, width, depth);
	}

	@Override
	public Biome[] getBiomes(Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag) {
		// TODO Auto-generated method stub
		return super.getBiomes(listToReuse, x, z, width, length, cacheFlag);
	}

	@Override
	public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed) {
		// TODO Auto-generated method stub
		return super.areBiomesViable(x, z, radius, allowed);
	}

	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
		// TODO Auto-generated method stub
		return super.findBiomePosition(x, z, range, biomes, random);
	}

	@Override
	public void cleanupCache() {
		// TODO Auto-generated method stub
		super.cleanupCache();
	}

	@Override
	public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original) {
		// TODO Auto-generated method stub
		return super.getModdedBiomeGenerators(worldType, seed, original);
	}

	@Override
	public boolean isFixedBiome() {
		// TODO Auto-generated method stub
		return super.isFixedBiome();
	}

	@Override
	public Biome getFixedBiome() {
		// TODO Auto-generated method stub
		return super.getFixedBiome();
	}

}
