package mm.world;

import java.util.List;

import mm.io.MarsTopologyLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;

public class ChunkProviderMM implements IChunkGenerator {
	
	private final World world;
	
	public ChunkProviderMM(World world)
	{
		this.world = world;
	}
	
	protected void generateTerrain(int cx, int cz, ChunkPrimer primer)
	{
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = cx * 16 + i;
				int z = cz * 16 + j;
				int h = MarsTopologyLoader.getElevation(x, z);
				for (int k = 0; k < 256; k++) {
					if ( k > h ) {
						primer.setBlockState(i, k, j, Blocks.AIR.getDefaultState());
					} else {
						primer.setBlockState(i, k, j, Blocks.STONE.getDefaultState());
					}
				}
			}
		}
	}

	@Override
	public Chunk provideChunk(final int cx, final int cz) {
		ChunkPrimer primer = new ChunkPrimer();
		generateTerrain(cx, cz, primer);
		
		return new Chunk(this.world, primer, cx, cz);
	}

	@Override
	public void populate(int x, int z) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180513_4_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub

	}

}
