package mm.world;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;

public class MartinMarsChunkProvider implements IChunkGenerator {
	
	private final World world;
	
	public MartinMarsChunkProvider(World world){
		this.world = world;
	}

	@Override
	public Chunk provideChunk(final int cx, final int cz) {
		final Chunk chunk = new Chunk(world, new ChunkPrimer(), cx, cz);
		return chunk;
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
